package cn.zeroable.cat4j.base.service.impl;

import cn.zeroable.cat4j.base.entity.UserRolePO;
import cn.zeroable.cat4j.base.mapper.UserRoleMapper;
import cn.zeroable.cat4j.base.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色表;(cat4j_user_role)表服务实现类
 *
 * @author : zeroable
 * @version : 2024-01-12 000:48:00
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRolePO> implements UserRoleService {

    @Override
    @Cacheable(cacheNames = "RoleCodes", key = "'roleCode_'+#userId")
    public List<String> getRoleCodeByUserId(Long userId) {
        return baseMapper.getRoleCodeByUserId(userId);
    }
}