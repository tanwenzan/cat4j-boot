package cn.zeroable.cat4j.base.service.impl;

import cn.dev33.satoken.oauth2.logic.SaOAuth2Util;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.SecureUtil;
import cn.zeroable.cat4j.base.entity.UserPO;
import cn.zeroable.cat4j.base.mapper.UserMapper;
import cn.zeroable.cat4j.base.pojo.dto.LoginDTO;
import cn.zeroable.cat4j.base.service.UserService;
import cn.zeroable.cat4j.core.ApiResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 用户表;(cat4j_user)表服务实现类
 *
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {
    @Override
    public ApiResult<String> login(@Validated LoginDTO userParam) {
        UserPO user = getOne(new QueryWrapper<UserPO>().lambda().in(UserPO::getLoginId, userParam.getUserName()));
        if (user == null) {
            return ApiResult.fail("用户名不存在");
        }
        String prePassWord = userParam.getPassWord();
        String salt = user.getSalt();
        String afterPassWord = SecureUtil.md5(prePassWord + salt).toUpperCase();
        if (afterPassWord.equals(user.getLoginPwd())) {
            StpUtil.login(user.getId());
            return ApiResult.ok();
        }
        return ApiResult.fail("密码错误");
    }
}