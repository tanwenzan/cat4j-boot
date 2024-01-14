package cn.zeroable.cat4j.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户角色表;
 *
 * @author : zeroable
 * @version : 2024-01-12 000:48:00
 * @since 0.0.1
 */
@Data
@ToString
@AllArgsConstructor
public class UserRole implements Serializable, Cloneable {

    private Long userId;

    private Long roleId;

    @Override
    public UserRole clone() {
        try {
            return (UserRole) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}