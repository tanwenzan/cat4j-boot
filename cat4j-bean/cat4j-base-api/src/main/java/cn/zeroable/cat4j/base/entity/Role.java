package cn.zeroable.cat4j.base.entity;

import cn.hutool.core.util.ObjectUtil;
import cn.zeroable.cat4j.base.po.RolePO;
import cn.zeroable.cat4j.base.vo.RoleVO;
import cn.zeroable.cat4j.core.util.AssertUtil;
import cn.zeroable.cat4j.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import cn.zeroable.cat4j.entity.BasePO;
import lombok.*;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色表;
 *
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity implements Serializable, Cloneable {

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色代码
     */
    private String roleCode;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * RolePO 转实体。
     *
     * @param rolePersistentObject RolePO 对象
     * @return cn.zeroable.cat4j.base.entity.Role
     * @author zeroable
     * @date 1/13/24 5:17 PM
     */
    public static Role byPersistentObject(RolePO rolePersistentObject) {
        Role role = new Role();
        BeanUtils.copyProperties(rolePersistentObject, role);
        return role;
    }

    /**
     * 转View Object。
     *
     * @return cn.zeroable.cat4j.base.vo.RoleVO View Object
     * @author zeroable
     * @date 1/13/24 5:18 PM
     */
    public RoleVO toViewObject() {
        RoleVO roleVO = new RoleVO();
        BeanUtils.copyProperties(this, roleVO);
        return roleVO;
    }

    public static List<RoleVO> batchCoverPersistentObjectToViewObject(List<RolePO> rolePersistentObjects) {
        if (ObjectUtil.isEmpty(rolePersistentObjects)) {
            return new ArrayList<>();
        }
        List<RoleVO> result = new ArrayList<>(rolePersistentObjects.size());
        for (RolePO rolePersistentObject : rolePersistentObjects) {
            result.add(coverPersistentObjectToViewObject(rolePersistentObject));
        }
        return result;
    }

    public static RoleVO coverPersistentObjectToViewObject(RolePO rolePersistentObject) {
        AssertUtil.notNull(rolePersistentObject, "持久层对象为空");
        RoleVO roleVO = new RoleVO();
        BeanUtils.copyProperties(rolePersistentObject, roleVO);
        return roleVO;
    }

    @Override
    public Role clone() {
        return (Role) super.clone();
    }
}