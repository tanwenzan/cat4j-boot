package cn.zeroable.cat4j.base.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.zeroable.cat4j.base.entity.Menu;
import cn.zeroable.cat4j.base.po.MenuPO;
import cn.zeroable.cat4j.base.service.MenuService;
import cn.zeroable.cat4j.base.vo.RouterInfo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import cn.zeroable.cat4j.base.mapper.MenuMapper;

import java.util.ArrayList;
import java.util.List;

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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuPO> implements MenuService {

    @Override
    public List<RouterInfo> getRouterByUserId(Long userId) {
        List<MenuPO> menus = baseMapper.getMenusByUserId(userId);
        if (ObjectUtil.isEmpty(menus)) {
            return new ArrayList<>();
        }
        return Menu.buildRouterInfos(menus);
    }
}