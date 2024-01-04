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
public class RolePO extends BasePO implements Serializable, Cloneable {
    /** 主键 */
    @TableId("id")
    private Long id;

    /** 角色名称 */
    @TableField("roleName")
    private String roleName;
    
    /** 角色代码 */
    @TableField("roleCode")
    private String roleCode;
    
    /** 角色描述 */
    @TableField("roleDesc")
    private String roleDesc;

    @Override
    public RolePO clone() {
        return (RolePO) super.clone();
    }
}