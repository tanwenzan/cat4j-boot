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
 * 字典表;
 *
 * @author : zeroable
 * @version : 2023-12-27 21:35:21
 * @since 0.0.1
 */
@TableName("cat4j_dict")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
public class DictPO extends BasePO implements Serializable, Cloneable {

    /**
     * 标识
     */
    @TableField("dictKey")
    private String dictKey;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

    /**
     * 是否是系统内置
     */
    @TableField("sysFlag")
    private Boolean sysFlag;


    @Override
    public DictPO clone() throws CloneNotSupportedException {
        return (DictPO) super.clone();
    }
}