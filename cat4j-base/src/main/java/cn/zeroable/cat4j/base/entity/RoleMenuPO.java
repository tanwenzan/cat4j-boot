package cn.zeroable.cat4j.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import cn.zeroable.cat4j.entity.BasePO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

 /**
 * 角色权限表;
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
@TableName("cat4j_role_menu")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
public class RoleMenuPO extends BasePO implements Serializable, Cloneable {
    /** 角色ID */
    @TableId("roleId")
    private Long id;
    
    
    
    /** 菜单ID */
    @TableField("menuId")
    private Long menuId;

    @Override
    public RoleMenuPO clone() {
        return (RoleMenuPO) super.clone();
    }
}