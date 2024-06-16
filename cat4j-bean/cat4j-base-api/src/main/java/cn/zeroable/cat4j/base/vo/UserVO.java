package cn.zeroable.cat4j.base.vo;

import cn.zeroable.cat4j.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户信息 view Object.
 *
 * @author zeroable
 * @version 2024/1/13 13:05
 * @since 0.0.1
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UserVO extends BaseEntity {
    /**
     * 账号
     */
    private String loginId;

    /**
     * 密码
     */
    private String loginPwd;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 所属组织
     */
    private Long orgId;

    /**
     * 随机盐
     */
    private String salt;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 锁定标识:0=正常,1=锁定
     */
    private Integer lockFlag;
}
