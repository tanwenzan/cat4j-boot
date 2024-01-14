package cn.zeroable.cat4j.base.entity;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import cn.zeroable.cat4j.base.dto.LoginDTO;
import cn.zeroable.cat4j.base.po.RolePO;
import cn.zeroable.cat4j.base.po.UserPO;
import cn.zeroable.cat4j.base.vo.RoleVO;
import cn.zeroable.cat4j.base.vo.UserVO;
import cn.zeroable.cat4j.core.ApiResult;
import cn.zeroable.cat4j.core.util.AssertUtil;
import cn.zeroable.cat4j.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import cn.zeroable.cat4j.entity.BasePO;
import lombok.*;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

/**
 * 用户POJO;
 *
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity implements Serializable, Cloneable {

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

    public static UserVO persistentObjectToViewObject(UserPO user) {
        AssertUtil.notNull(user, "转换失败：用户信息为空");
        UserVO userViewObject = new UserVO();
        BeanUtils.copyProperties(user, userViewObject);
        return userViewObject;
    }

    public boolean isLock() {
        return lockFlag != null && lockFlag == 1;
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

    /**
     * UserPO 转实体。
     *
     * @param rolePersistentObject UserPO 对象
     * @return cn.zeroable.cat4j.base.entity.User
     * @author zeroable
     * @date 1/13/24 5:17 PM
     */
    public static User byPersistentObject(UserPO rolePersistentObject) {
        User user = new User();
        BeanUtils.copyProperties(rolePersistentObject, user);
        return user;
    }

    /**
     * 转View Object。
     *
     * @return cn.zeroable.cat4j.base.vo.UserVO View Object
     * @author zeroable
     * @date 1/13/24 5:18 PM
     */
    public UserVO toViewObject() {
        UserVO roleVO = new UserVO();
        BeanUtils.copyProperties(this, roleVO);
        return roleVO;
    }

    @Override
    public User clone() {
        return (User) super.clone();
    }
}