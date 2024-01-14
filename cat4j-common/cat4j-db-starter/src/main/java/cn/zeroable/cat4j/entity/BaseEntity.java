package cn.zeroable.cat4j.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础实体类.
 *
 * @author zeroable
 * @version 1/13/24 4:23 PM
 * @since 0.0.1
 */
@NoArgsConstructor
@Data
public class BaseEntity implements Serializable,Cloneable {

    private Long id;

    private Long createBy;

    private LocalDateTime createTime;

    private Long updateBy;

    private LocalDateTime updateTime;

    @Override
    public BaseEntity clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (BaseEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
