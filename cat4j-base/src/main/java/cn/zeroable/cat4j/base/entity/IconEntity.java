package cn.zeroable.cat4j.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import cn.zeroable.cat4j.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

 /**
 * 图标表;
 * @author : zeroable
 * @version : 2024-02-07 10:08:10
 * @since 0.0.1
 */
@TableName("cat4j_icon")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
public class IconEntity extends BaseEntity implements Serializable, Cloneable {
    
    
    /** 类型 */
    @TableField("type")
    private Integer type;
    
    /** 图标标识 */
    @TableField("key")
    private String key;
    
    /** 图标名称 */
    @TableField("value")
    private String value;

    @Override
    public IconEntity clone() {
        return (IconEntity) super.clone();
    }
}