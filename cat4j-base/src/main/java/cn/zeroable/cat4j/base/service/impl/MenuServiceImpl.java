package cn.zeroable.cat4j.base.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.zeroable.cat4j.base.entity.MenuEntity;
import cn.zeroable.cat4j.base.service.MenuService;
import cn.zeroable.cat4j.base.vo.MenuVO;
import cn.zeroable.cat4j.base.vo.RouterInfo;
import cn.zeroable.cat4j.base.vo.RouterMetaInfo;
import cn.zeroable.cat4j.core.util.BeanCovertUtil;
import cn.zeroable.cat4j.support.Condition;
import cn.zeroable.cat4j.support.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import cn.zeroable.cat4j.base.mapper.MenuMapper;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 菜单表;
 *
 * @author : zeroable
 * @version : 2023-12-27 21:07:21
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements MenuService {


    @Override
    public List<RouterInfo> getRouterByUserId(Long userId) {
        List<MenuEntity> menus = baseMapper.getMenusByUserId(userId);
        if (ObjectUtil.isEmpty(menus)) {
            return new ArrayList<>();
        }
        return buildRouterInfos(menus);
    }

    @Override
    public IPage<MenuVO> page(MenuEntity menu, Query query) {
        QueryWrapper<MenuEntity> queryWrapper = Condition.getQueryWrapper(menu);
        // 只获取父节点。根据这些父节点然后去构造全部的子节点
        queryWrapper.and((wrapper) -> wrapper.lambda().eq(MenuEntity::getParentId, 0));
        IPage<MenuEntity> entityPage = page(Condition.getPage(query), queryWrapper);
        if (ObjectUtil.isEmpty(entityPage.getRecords())) {
            return Condition.getPage(query);
        }
        IPage<MenuVO> page = entityPage.convert((menuEntity -> BeanCovertUtil.copyProperties(menuEntity, MenuVO.class)));
        // 获取子节点信息。
        List<MenuVO> childrenList = listByParentIds(page.getRecords().stream().map(MenuVO::getId).toList()).stream()
                .map((menuEntity -> BeanCovertUtil.copyProperties(menuEntity, MenuVO.class)))
                .collect(Collectors.toList());
        if (ObjectUtil.isNotEmpty(childrenList)) {
            childrenList.addAll(page.getRecords());
            page.setRecords(processViewObjects(childrenList));
        }
        return page;
    }

    private List<MenuEntity> listByParentIds(Collection<Long> parentIds) {
        return list(new QueryWrapper<MenuEntity>().lambda().in(MenuEntity::getParentId, parentIds));
    }

    /**
     * 构建 路由信息。
     *
     * @param menus 菜单持久层对象
     * @return java.util.List<cn.zeroable.cat4j.base.vo.RouterInfo>
     * @author zeroable
     * @date 1/14/24 12:40 AM
     */
    public List<RouterInfo> buildRouterInfos(List<MenuEntity> menus) {
        List<MenuVO> menuViewObjects = buildViewObjects(menus);
        List<RouterInfo> result = convertRouterInfos(menuViewObjects);
        for (RouterInfo routerInfo : result) {
            processRouterInfo(routerInfo, null);
        }
        return result;
    }

    private void processRouterInfo(RouterInfo routerInfo, RouterInfo parent) {
        boolean hasChildren = ObjectUtil.isNotEmpty(routerInfo.getChildren());
        String redirect = routerInfo.getPath();
        // 说明是顶级菜单
        if (parent == null) {
            routerInfo.setComponent("#");
        } else {
            redirect = parent.getRedirect() + "/" + redirect;
            parent.setRedirect(redirect);
            // 多级菜单处理
            if (hasChildren) {
                routerInfo.setRedirect(redirect);
                routerInfo.setComponent("##");
            } else {
                // 叶子菜单无需重定向
                routerInfo.setRedirect(null);
            }
        }
        if (hasChildren) {
            for (RouterInfo child : routerInfo.getChildren()) {
                processRouterInfo(child, routerInfo);
            }
        }
    }

    /**
     * 构建 {@code MenuVO}。
     *
     * @param menus MenuPOList
     * @return java.util.List<cn.zeroable.cat4j.base.vo.MenuVO>
     * @author zeroable
     * @date 2024/1/26 11:15
     */
    private List<MenuVO> buildViewObjects(List<MenuEntity> menus) {
        if (ObjectUtil.isEmpty(menus)) {
            return new ArrayList<>();
        }
        List<MenuVO> menuViewObjects = toViewObjects(menus);
        return processViewObjects(menuViewObjects);
    }

    /**
     * 处理菜单，将其处理为Tree 结构。
     *
     * @param menuViewObjects menuViewObjects
     * @return java.util.List<cn.zeroable.cat4j.base.vo.MenuVO> 根节点的信息。
     * @author zeroable
     * @date 2024/1/31 17:01
     */
    private List<MenuVO> processViewObjects(List<MenuVO> menuViewObjects) {
        List<MenuVO> result = new ArrayList<>();
        if (ObjectUtil.isEmpty(menuViewObjects)) {
            return result;
        }
        // id -> childrenId 映射
        Map<Long, List<Long>> treePathMapping = new HashMap<>();
        // childrenId -> MenuVO 映射
        Map<Long, MenuVO> idViewObjectMapping = new HashMap<>();
        // 先遍历生成映射
        for (MenuVO menuViewObject : menuViewObjects) {
            Long parentId = menuViewObject.getParentId();
            Long id = menuViewObject.getId();
            if (!treePathMapping.containsKey(parentId)) {
                treePathMapping.put(parentId, new ArrayList<>());
            }
            treePathMapping.get(parentId).add(id);
            idViewObjectMapping.put(id, menuViewObject);
        }
        // 这里默认根目录的父id 为0
        List<Long> rootMenus = treePathMapping.get(0L);
        if (ObjectUtil.isEmpty(rootMenus)) {
            return result;
        }
        treePathMapping.forEach((id, childIds) -> {
            MenuVO current = idViewObjectMapping.get(id);
            if (ObjectUtil.isNotEmpty(childIds) && current != null) {
                List<MenuVO> childrenList = new ArrayList<>(childIds.size());
                for (Long childId : childIds) {
                    childrenList.add(idViewObjectMapping.get(childId));
                }
                current.setChildren(childrenList);
            }
        });
        for (Long rootMenu : rootMenus) {
            result.add(idViewObjectMapping.get(rootMenu));
        }
        return result;
    }

    /**
     * 将 {@code List<MenuPO>} 转化为 {@code List<MenuVO>}。
     *
     * @param menus MenuPOList
     * @return java.util.List<cn.zeroable.cat4j.base.vo.MenuVO>
     * @author zeroable
     * @date 2024/1/26 11:08
     */
    private static List<MenuVO> toViewObjects(List<MenuEntity> menus) {
        if (ObjectUtil.isEmpty(menus)) {
            return new ArrayList<>();
        }
        List<MenuVO> menuViewObjects = new ArrayList<>(menus.size());
        for (MenuEntity menu : menus) {
            MenuVO menuViewObject = new MenuVO();
            BeanUtils.copyProperties(menu, menuViewObject);
            menuViewObjects.add(menuViewObject);
        }
        return menuViewObjects;
    }


    private List<RouterInfo> convertRouterInfos(List<MenuVO> menuViewObjects) {
        if (ObjectUtil.isEmpty(menuViewObjects)) {
            return new ArrayList<>();
        }
        List<RouterInfo> result = new ArrayList<>(menuViewObjects.size());
        for (MenuVO menuViewObject : menuViewObjects) {
            result.add(convertRouterInfo(menuViewObject, true));
        }
        return result;
    }

    /**
     * 将 {@code menuVO} 转化为  {@code RouterInfo}。
     *
     * @param menuVO menuVO
     * @param isRoot 是否是跟节点
     * @return cn.zeroable.cat4j.base.vo.RouterInfo
     * @author zeroable
     * @date 2024/1/26 11:16
     */
    private RouterInfo convertRouterInfo(MenuVO menuVO, boolean isRoot) {
        RouterInfo routerInfo = new RouterInfo();
        String code = menuVO.getCode();
        routerInfo.setName(code);
        String path = code;
        if (isRoot) {
            path = "/" + code;
        }
        routerInfo.setPath(path);
        routerInfo.setRedirect(path);
        RouterMetaInfo routerMetaInfo = new RouterMetaInfo();
        routerInfo.setMeta(routerMetaInfo);
        routerMetaInfo.setIcon(menuVO.getIcon());
        routerMetaInfo.setTitle(menuVO.getName());
        routerInfo.setComponent(menuVO.getPath());
        routerMetaInfo.setBreadcrumb(true);
        routerMetaInfo.setAlwaysShow(false);
        routerMetaInfo.setNoCache(false);
        routerMetaInfo.setHidden(false);
        routerMetaInfo.setAffix(false);
        List<MenuVO> childrenList = menuVO.getChildren();
        List<String> permission = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(childrenList)) {
            List<RouterInfo> childRouters = new ArrayList<>();
            for (MenuVO children : childrenList) {
                if (MenuEntity.MENU_TYPE_BUTTON.equals(children.getType())) {
                    permission.add(children.getPermission());
                } else {
                    // 递归处理子节点信息
                    childRouters.add(convertRouterInfo(children, false));
                }
            }
            routerInfo.setChildren(childRouters);
        }
        if (ObjectUtil.isNotEmpty(menuVO.getPermission())) {
            permission.add(menuVO.getPermission());
        }
        routerMetaInfo.setPermission(permission);
        return routerInfo;
    }

}