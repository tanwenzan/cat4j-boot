package cn.zeroable.cat4j.base.po;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * 用户角色表;
 *
 * @author : zeroable
 * @version : 2024-01-12 000:48:00
 * @since 0.0.1
 */
@TableName("cat4j_user_role")
@Data
@ToString
@AllArgsConstructor
public class UserRole implements Serializable, Cloneable {

    @TableId("user_id")
    private Long userId;

    @TableField("role_id")
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