package cn.zeroable.cat4j.base.po;

import cn.zeroable.cat4j.entity.BasePO;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * 菜单表;
 *
 * @author : zeroable
 * @version : 2023-12-27 21:07:21
 * @since 0.0.1
 */
@TableName("cat4j_menu")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MenuPO extends BasePO implements Serializable, Cloneable {

    /**
     * 父菜单ID
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 菜单路径
     */
    @TableField("tree_path")
    private String treePath;

    /**
     * 菜单编码
     */
    @TableField("code")
    private String code;

    /**
     * 菜单名称
     */
    @TableField("name")
    private String name;

    /**
     * 菜单权限标识
     */
    @TableField("permission")
    private String permission;

    /**
     * 前端UI路径
     */
    @TableField("path")
    private String path;

    /**
     * 图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 排序值
     */
    @TableField("sort_order")
    private String sortOrder;

    /**
     * 0-开启，1- 关闭
     */
    @TableField("keep_alive")
    private String keepAlive;

    /**
     * 类型 （0菜单 1按钮）
     */
    @TableField("type")
    private Integer type;

    /**
     * 菜单类型（0 元对象 1 代码）
     */
    @TableField("menu_type")
    private Integer menuType;

    /**
     * 菜单配置
     */
    @TableField("menu_config")
    private String menuConfig;

    @Override
    public MenuPO clone() {
        return (MenuPO) super.clone();
    }
}