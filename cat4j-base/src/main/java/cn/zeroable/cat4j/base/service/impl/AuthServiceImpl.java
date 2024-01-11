package cn.zeroable.cat4j.base.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import cn.zeroable.cat4j.base.dto.LoginDTO;
import cn.zeroable.cat4j.base.entity.UserPO;
import cn.zeroable.cat4j.base.service.AuthService;
import cn.zeroable.cat4j.base.service.UserService;
import cn.zeroable.cat4j.core.ApiResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 简要说明.
 * <br/> 详细说明.
 *
 * @author zeroable
 * @version 1/11/24 11:55 PM
 * @see
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    @Override
    public ApiResult<SaTokenInfo> login(@Validated LoginDTO loginDTO) {
        UserPO user = userService.getOne(new QueryWrapper<UserPO>().lambda().in(UserPO::getLoginId, loginDTO.getUserName()));
        if (ObjectUtil.isEmpty(user)) {
            return ApiResult.fail("用户名不存在");
        }
        String prePassWord = loginDTO.getPassWord();
        String salt = user.getSalt();
        String afterPassWord = SecureUtil.md5(prePassWord + salt).toUpperCase();
        if (afterPassWord.equals(user.getLoginPwd())) {
            StpUtil.login(user.getId());
            return ApiResult.ok(StpUtil.getTokenInfo());
        }
        return ApiResult.fail("密码错误");
    }
}
