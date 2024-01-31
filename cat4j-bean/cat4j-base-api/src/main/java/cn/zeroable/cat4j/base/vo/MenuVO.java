package cn.zeroable.cat4j.base.vo;

import cn.hutool.core.util.ObjectUtil;
import cn.zeroable.cat4j.entity.BaseEntity;
import lombok.*;

import java.util.List;

/**
 * 菜单 View Object.
 *
 * @author zeroable
 * @version 1/14/24 12:42 AM
 * @since 0.0.1
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO extends BaseEntity {

    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 菜单路径
     */
    private String treePath;

    /**
     * 菜单编码
     */
    private String code;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单权限标识
     */
    private String permission;

    /**
     * 前端UI路径
     */
    private String path;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序值
     */
    private String sortOrder;

    /**
     * 0-开启，1- 关闭
     */
    private String keepAlive;

    /**
     * 类型 （0菜单 1按钮）
     */
    private Integer type;

    /**
     * 菜单类型（0 元对象 1 代码）
     */
    private Integer menuType;

    /**
     * 菜单配置
     */
    private String menuConfig;

    /**
     * 子菜单
     */
    private List<MenuVO> children;

    /**
     * 此方法是提供给spring 处理响应数据时进行set的 所以请勿删除。
     *
     * @return boolean
     * @author zeroable
     * @date 2024/1/31 16:43
     */
    public boolean getHasChildren() {
        return ObjectUtil.isNotEmpty(children);
    }
}
