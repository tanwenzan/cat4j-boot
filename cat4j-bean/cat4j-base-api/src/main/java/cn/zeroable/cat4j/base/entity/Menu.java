package cn.zeroable.cat4j.base.entity;

import cn.hutool.core.util.ObjectUtil;
import cn.zeroable.cat4j.base.po.MenuPO;
import cn.zeroable.cat4j.base.vo.MenuVO;
import cn.zeroable.cat4j.base.vo.RouterInfo;
import cn.zeroable.cat4j.base.vo.RouterMetaInfo;
import cn.zeroable.cat4j.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单 POJO;
 *
 * @author : zeroable
 * @version : 2023-12-27 21:07:21
 * @since 0.0.1
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
public class Menu extends BaseEntity implements Serializable, Cloneable {

    private static final Integer MENU_TYPE_BUTTON = 1;

    private static final Integer MENU_TYPE_MENU = 0;

    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 菜单路径
     */
    private String treePath;

    /**
     * 菜单编码
     */
    private String code;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单权限标识
     */
    private String permission;

    /**
     * 前端UI路径
     */
    private String path;

    /**
     * 图标
     */
    private String con;

    /**
     * 排序值
     */
    private String sortOrder;

    /**
     * 0-开启，1- 关闭
     */
    private String keepAlive;

    /**
     * 类型 （0菜单 1按钮）
     */
    private Integer type;

    /**
     * 菜单类型（0 元对象 1 代码）
     */
    private Integer menuType;

    /**
     * 菜单配置
     */
    private String menuConfig;

    /**
     * 构建 路由信息。
     *
     * @param menus 菜单持久层对象
     * @return java.util.List<cn.zeroable.cat4j.base.vo.RouterInfo>
     * @author zeroable
     * @date 1/14/24 12:40 AM
     */
    public static List<RouterInfo> buildRouterInfos(List<MenuPO> menus) {
        List<MenuVO> menuViewObjects = buildViewObjects(menus);
        List<RouterInfo> result = convertRouterInfos(menuViewObjects);
        for (RouterInfo routerInfo : result) {
            processRouterInfo(routerInfo, null);
        }
        return result;
    }

    private static void processRouterInfo(RouterInfo routerInfo, RouterInfo parent) {
        boolean hasChildren = ObjectUtil.isNotEmpty(routerInfo.getChildren());
        String redirect = routerInfo.getPath();
        // 说明是顶级菜单
        if (parent == null) {
            routerInfo.setComponent("#");
        } else {
            redirect = parent.getPath() + "/" + redirect;
            parent.setRedirect(redirect);
            // 多级菜单处理
            if (hasChildren) {
                routerInfo.setComponent("##");
            }
        }
        if (hasChildren) {

            for (RouterInfo child : routerInfo.getChildren()) {
                processRouterInfo(child, routerInfo);
            }
        }
    }

    private static List<RouterInfo> convertRouterInfos(List<MenuVO> menuViewObjects) {
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
     * @param menuViewObject menuVO
     * @param isRoot         是否是跟节点
     * @return cn.zeroable.cat4j.base.vo.RouterInfo
     * @author tanwenzan
     * @date 2024/1/26 11:16
     */
    private static RouterInfo convertRouterInfo(MenuVO menuViewObject, boolean isRoot) {
        RouterInfo routerInfo = new RouterInfo();
        String code = menuViewObject.getCode();
        routerInfo.setName(code);
        String path = code;
        if (isRoot) {
            path = "/" + code;
        }
        routerInfo.setPath(path);
        RouterMetaInfo routerMetaInfo = new RouterMetaInfo();
        routerInfo.setMeta(routerMetaInfo);
        routerMetaInfo.setIcon(menuViewObject.getIcon());
        routerMetaInfo.setTitle(menuViewObject.getName());
        routerInfo.setComponent(menuViewObject.getPath());
//        routerMetaInfo.setBreadcrumb(true);
//        routerMetaInfo.setAlwaysShow(false);
//        routerMetaInfo.setNoCache(false);
//        routerMetaInfo.setHidden(false);
//        routerMetaInfo.setAffix(false);
        List<MenuVO> childrenList = menuViewObject.getChildren();
        List<String> permission = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(childrenList)) {
            List<RouterInfo> childRouters = new ArrayList<>();
            for (MenuVO menuVO : childrenList) {
                if (MENU_TYPE_BUTTON.equals(menuVO.getType())) {
                    permission.add(menuVO.getPermission());
                } else {
                    // 递归处理子节点信息
                    childRouters.add(convertRouterInfo(menuVO, false));
                }
            }
            routerInfo.setChildren(childRouters);
        }
        if (ObjectUtil.isNotEmpty(menuViewObject.getPermission())) {
            permission.add(menuViewObject.getPermission());
        }
        routerMetaInfo.setPermission(permission);
        return routerInfo;
    }

    /**
     * 构建 {@code MenuVO}。
     *
     * @param menus MenuPOList
     * @return java.util.List<cn.zeroable.cat4j.base.vo.MenuVO>
     * @author tanwenzan
     * @date 2024/1/26 11:15
     */
    public static List<MenuVO> buildViewObjects(List<MenuPO> menus) {
        List<MenuVO> result = new ArrayList<>();
        if (ObjectUtil.isEmpty(menus)) {
            return result;
        }
        List<MenuVO> menuViewObjects = toViewObjects(menus);
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
     * @author tanwenzan
     * @date 2024/1/26 11:08
     */
    private static List<MenuVO> toViewObjects(List<MenuPO> menus) {
        if (ObjectUtil.isEmpty(menus)) {
            return new ArrayList<>();
        }
        List<MenuVO> menuViewObjects = new ArrayList<>(menus.size());
        for (MenuPO menu : menus) {
            MenuVO menuViewObject = new MenuVO();
            BeanUtils.copyProperties(menu, menuViewObject);
            menuViewObjects.add(menuViewObject);
        }
        return menuViewObjects;
    }

    @Override
    public Menu clone() {
        return (Menu) super.clone();
    }
}