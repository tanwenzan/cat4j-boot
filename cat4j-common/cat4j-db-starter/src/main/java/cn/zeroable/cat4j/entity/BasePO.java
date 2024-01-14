package cn.zeroable.cat4j.entity;

import cn.zeroable.cat4j.core.Long2StringSerializer;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 数据库基础实体类.
 *
 * @author zeroable
 * @version 12/24/23 10:02 PM
 * @since 0.0.1
 */
@Getter
@Setter
public class BasePO implements Serializable, Cloneable {

    //使用自己实现的类型转换
    @TableId("id")
    @JsonSerialize(using = Long2StringSerializer.class)
    private Long id;

    @Version
    @TableField("re_version")
    private Integer reVersion;

    @TableField("create_by")
    private Long createBy;

    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField("update_by")
    private Long updateBy;

    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @TableLogic
    @TableField("hide")
    private Boolean hide;

    @Override
    public BasePO clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (BasePO) super.clone();

        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
