package cn.zeroable.cat4j.base.vo;

import cn.zeroable.cat4j.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 角色信息 View Object.
 *
 * @author tanwenzan
 * @version 2024/1/13 13:09
 * @since 0.0.1
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class RoleVO extends BaseEntity {

    /** 角色名称 */
    private String roleName;

    /** 角色代码 */
    private String roleCode;

    /** 角色描述 */
    private String roleDesc;
}
