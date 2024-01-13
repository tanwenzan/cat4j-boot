package cn.zeroable.cat4j.base.po;

import com.baomidou.mybatisplus.annotation.TableField;
import cn.zeroable.cat4j.entity.BasePO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 字典明细;
 *
 * @author : zeroable
 * @version : 2023-12-27 21:35:21
 * @since 0.0.1
 */
@TableName("cat4j_dict_item")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
public class DictItem extends BasePO implements Serializable, Cloneable {
    /**
     * 字典ID
     */
    @TableField("dict_id")
    private String dictId;

    /**
     * 字典标识
     */
    @TableField("dict_key")
    private String dictKey;

    /**
     * 值
     */
    @TableField("value")
    private String value;

    /**
     * 标签
     */
    @TableField("label")
    private String label;

    /**
     * 字典类型
     */
    @TableField("type")
    private String type;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

    /**
     * 排序（升序）
     */
    @TableField("sort_order")
    private Integer sortOrder;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    @Override
    public DictItem clone() {
        return (DictItem) super.clone();
    }
}