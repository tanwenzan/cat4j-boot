package cn.zeroable.cat4j.base.service.impl;

import cn.zeroable.cat4j.base.entity.Role;
import cn.zeroable.cat4j.base.mapper.RoleMapper;
import cn.zeroable.cat4j.base.po.RolePO;
import cn.zeroable.cat4j.base.service.RoleService;
import cn.zeroable.cat4j.base.vo.RoleVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色表;(cat4j_role)表服务实现类
 *
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RolePO> implements RoleService {
    @Override
    public List<RoleVO> getRolesByUserId(Long userId) {
        List<RolePO> roles = baseMapper.getRolesByUserId(userId);
        return Role.batchCoverPersistentObjectToViewObject(roles);
    }
}