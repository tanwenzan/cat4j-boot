package cn.zeroable.cat4j.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import cn.zeroable.cat4j.entity.BasePO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;

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
public class MenuPO extends BasePO implements Serializable, Cloneable {

    /**
     * 父菜单ID
     */
    @TableField("parentId")
    private String parentId;

    /**
     * 菜单路径
     */
    @TableField("treePath")
    private String treePath;

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
    private String con;

    /**
     * 排序值
     */
    @TableField("sortOrder")
    private String sortOrder;

    /**
     * 0-开启，1- 关闭
     */
    @TableField("keepAlive")
    private String keepAlive;

    /**
     * 类型 （0菜单 1按钮）
     */
    @TableField("type")
    private Integer type;

    /**
     * 菜单类型（0 元对象 1 代码）
     */
    @TableField("menuType")
    private Integer menuType;

    /**
     * 菜单配置
     */
    @TableField("menuConfig")
    private String menuConfig;

    @Override
    public MenuPO clone() {
        return (MenuPO) super.clone();
    }
}