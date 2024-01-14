package cn.zeroable.cat4j.base.entity;

import cn.zeroable.cat4j.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 字典POJO;
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
public class Dict extends BaseEntity implements Serializable, Cloneable {

    /**
     * 标识
     */
    private String dictKey;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否是系统内置
     */
    private Boolean sysFlag;


    @Override
    public Dict clone() {
        return (Dict) super.clone();
    }
}