package cn.zeroable.cat4j.base.entity;

import cn.zeroable.cat4j.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 组织架构 POJO;
 *
 * @author : zeroable
 * @version : 2023-12-27 21:32:21
 * @since 0.0.1
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
public class Organization extends BaseEntity implements Serializable, Cloneable {

    /**
     * 父节点
     */
    private Long parentId;

    /**
     * 组织架构名称
     */
    private String orgName;

    /**
     * 路径
     */
    private String path;


    @Override
    public Organization clone() {
        return (Organization) super.clone();
    }
}