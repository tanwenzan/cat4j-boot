package cn.zeroable.cat4j.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 角色权限表;
 *
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
@Data
@ToString
@AllArgsConstructor
public class RoleMenu implements Serializable {

    /**
     * 角色ID
     */
    private Long id;

    /**
     * 菜单ID
     */
    private Long menuId;
}