package cn.zeroable.cat4j.base.entity;

import cn.zeroable.cat4j.entity.BasePO;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 角色表;
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
@TableName("cat4j_role")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
public class RoleEntity extends BasePO implements Serializable, Cloneable {

    /** 角色名称 */
    @TableField("role_name")
    private String roleName;
    
    /** 角色代码 */
    @TableField("role_code")
    private String roleCode;
    
    /** 角色描述 */
    @TableField("role_desc")
    private String roleDesc;

    @Override
    public RoleEntity clone() {
        return (RoleEntity) super.clone();
    }
}