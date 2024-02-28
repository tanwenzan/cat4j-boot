package cn.zeroable.cat4j.base.entity;

import cn.hutool.crypto.SecureUtil;
import cn.zeroable.cat4j.base.dto.LoginDTO;
import cn.zeroable.cat4j.core.ApiResult;
import cn.zeroable.cat4j.entity.BasePO;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * 用户表;
 *
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
@TableName("cat4j_user")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BasePO implements Serializable, Cloneable {

    /**
     * 账号
     */
    @TableField("login_id")
    @NotBlank(message = "用户的账号不能为空")
    private String loginId;

    /**
     * 密码
     */
    @TableField("login_pwd")
    @NotBlank(message = "用户的密码不能为空")
    private String loginPwd;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 所属组织
     */
    @TableField("org_id")
    private Long orgId;

    /**
     * 随机盐
     */
    @TableField("salt")
    private String salt;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 手机号码
     */
    @TableField("phone_number")
    private String phoneNumber;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 简介
     */
    @TableField("introduction")
    private String introduction;

    /**
     * 锁定标识:0=正常,1=锁定
     */
    @TableField("lock_flag")
    private Integer lockFlag;

    @Override
    public UserEntity clone() {
        return (UserEntity) super.clone();
    }

    public boolean isLock() {
        return lockFlag != null && lockFlag == 1;
    }

    public void lock() {
        this.lockFlag = 1;
    }

    public ApiResult<String> validatedLogin(LoginDTO loginInfo) {
        if (isLock()) {
            return ApiResult.fail("当前账号被锁定，请联系管理员解锁");
        }
        String prePassWord = loginInfo.getPassWord().toUpperCase();
        String afterPassWord = SecureUtil.md5(prePassWord + salt).toUpperCase();
        if (afterPassWord.equals(loginPwd)) {
            return ApiResult.ok();
        }
        return ApiResult.fail("密码错误");
    }
}