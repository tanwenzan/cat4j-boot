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
 *
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
@TableName("cat4j_role_menu")
@Data
@ToString
@AllArgsConstructor
public class RoleMenuPO implements Serializable {

    /**
     * 角色ID
     */
    @TableId("role_id")
    private Long id;

    /**
     * 菜单ID
     */
    @TableField("menu_id")
    private Long menuId;
}