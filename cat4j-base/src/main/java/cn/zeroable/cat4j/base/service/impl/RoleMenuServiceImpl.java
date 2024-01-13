package cn.zeroable.cat4j.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import cn.zeroable.cat4j.base.po.RoleMenu;
import cn.zeroable.cat4j.base.mapper.RoleMenuMapper;
import cn.zeroable.cat4j.base.service.RoleMenuService;

import java.util.List;

/**
 * 角色权限表;(cat4j_role_menu)表服务实现类
 *
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {
    @Override
    @Cacheable(cacheNames = "PermissionList", key = "'permission_'+#loginId")
    public List<String> getPermissionList(Object loginId) {
        return baseMapper.getPermissionList(loginId);
    }
}