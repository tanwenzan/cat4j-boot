package cn.zeroable.cat4j.base.service;

import cn.zeroable.cat4j.base.entity.MenuEntity;
import cn.zeroable.cat4j.base.vo.MenuVO;
import cn.zeroable.cat4j.base.vo.RouterInfo;
import cn.zeroable.cat4j.support.Query;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 菜单Service 接口.
 *
 * @author zeroable
 * @version 1/13/24 4:50 PM
 * @since 0.0.1
 */
public interface MenuService extends IService<MenuEntity> {

    /**
     * 获取当前用户的路由信息。
     *
     * @param userId 用户id
     * @return java.util.List<cn.zeroable.cat4j.base.vo.RouterInfo>
     * @author zeroable
     * @date 1/13/24 11:13 PM
     */
    List<RouterInfo> getRouterByUserId(Long userId);

    IPage<MenuVO> page(MenuEntity menu, Query query);
}
