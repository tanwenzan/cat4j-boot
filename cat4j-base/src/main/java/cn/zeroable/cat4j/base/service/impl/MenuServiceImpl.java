package cn.zeroable.cat4j.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import cn.zeroable.cat4j.base.entity.MenuPO;
import cn.zeroable.cat4j.base.mapper.MenuMapper;
import cn.zeroable.cat4j.base.service.MenuService;

/**
 * 菜单表;(cat4j_menu)表服务实现类
 *
 * @author : zeroable
 * @version : 2023-12-27 21:07:21
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuPO> implements MenuService {
}