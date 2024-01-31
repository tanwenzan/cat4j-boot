package cn.zeroable.cat4j.base.entity;

import cn.zeroable.cat4j.entity.BasePO;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 组织架构;
 *
 * @author : zeroable
 * @version : 2023-12-27 21:32:21
 * @since 0.0.1
 */
@TableName("cat4j_organization")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
public class OrganizationEntity extends BasePO implements Serializable, Cloneable {

    /**
     * 父节点
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 组织架构名称
     */
    @TableField("org_name")
    private String orgName;

    /**
     * 路径
     */
    @TableField("path")
    private String path;


    @Override
    public OrganizationEntity clone() {
        return (OrganizationEntity) super.clone();
    }
}