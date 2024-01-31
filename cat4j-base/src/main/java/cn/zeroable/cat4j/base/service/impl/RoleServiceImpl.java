package cn.zeroable.cat4j.base.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.zeroable.cat4j.base.entity.RoleEntity;
import cn.zeroable.cat4j.base.mapper.RoleMapper;
import cn.zeroable.cat4j.base.service.RoleService;
import cn.zeroable.cat4j.base.vo.RoleVO;
import cn.zeroable.cat4j.core.util.AssertUtil;
import cn.zeroable.cat4j.core.util.BeanCovertUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {
    @Override
    public List<RoleVO> getRolesByUserId(Long userId) {
        List<RoleEntity> roles = baseMapper.getRolesByUserId(userId);
        return batchCoverToViewObject(roles);
    }

    private List<RoleVO> batchCoverToViewObject(List<RoleEntity> roles) {
        if (ObjectUtil.isEmpty(roles)) {
            return new ArrayList<>();
        }
        List<RoleVO> result = new ArrayList<>(roles.size());
        for (RoleEntity roleEntity : roles) {
            result.add(coverToViewObject(roleEntity));
        }
        return result;
    }

    private RoleVO coverToViewObject(RoleEntity roleEntity) {
        AssertUtil.notNull(roleEntity, "持久层对象为空");
        return BeanCovertUtil.copyProperties(roleEntity, RoleVO.class);
    }
}