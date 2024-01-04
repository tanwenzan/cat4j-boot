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
public class OrganizationPO extends BasePO implements Serializable, Cloneable {

    /**
     * 父节点
     */
    @TableField("parentId")
    private Long parentId;

    /**
     * 组织架构名称
     */
    @TableField("orgName")
    private String orgName;

    /**
     * 路径
     */
    @TableField("path")
    private String path;


    @Override
    public OrganizationPO clone() {
        return (OrganizationPO) super.clone();
    }
}