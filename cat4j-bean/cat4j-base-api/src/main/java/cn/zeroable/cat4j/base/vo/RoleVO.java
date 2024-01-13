package cn.zeroable.cat4j.base.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 角色信息 View Object.
 *
 * @author tanwenzan
 * @version 2024/1/13 13:09
 * @since 0.0.1
 */
@Data
public class RoleVO {

    @TableId("id")
    private Long id;

    /** 角色名称 */
    @TableField("role_name")
    private String roleName;

    /** 角色代码 */
    @TableField("role_code")
    private String roleCode;

    /** 角色描述 */
    @TableField("role_desc")
    private String roleDesc;
}
