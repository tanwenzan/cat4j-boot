package cn.zeroable.cat4j.base.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.zeroable.cat4j.base.dto.LoginDTO;
import cn.zeroable.cat4j.base.entity.UserEntity;
import cn.zeroable.cat4j.base.enums.LoginDeviceType;
import cn.zeroable.cat4j.base.service.AuthService;
import cn.zeroable.cat4j.base.service.RoleMenuService;
import cn.zeroable.cat4j.base.service.UserRoleService;
import cn.zeroable.cat4j.base.service.UserService;
import cn.zeroable.cat4j.base.vo.LoginResult;
import cn.zeroable.cat4j.core.ApiResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * 认证接口实现类.
 *
 * @author zeroable
 * @version 1/11/24 11:55 PM
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    private RoleMenuService roleMenuService;

    private UserRoleService userRoleService;

    @Override
    public ApiResult<LoginResult> login(@Validated LoginDTO loginDTO) {
        UserEntity user = userService.getOne(new QueryWrapper<UserEntity>().lambda()
                .eq(UserEntity::getLoginId, loginDTO.getUserName()));
        if (ObjectUtil.isEmpty(user)) {
            return ApiResult.fail("用户名不存在");
        }
        ApiResult<String> loginResult = user.validatedLogin(loginDTO);
        if (loginResult.getSuccess()) {
            Long userId = user.getId();
            StpUtil.login(userId);
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            try {
                List<String> permissionList = roleMenuService.getPermissionList(userId);
                List<String> roles = userRoleService.getRoleCodeByUserId(userId);
                LoginResult result = new LoginResult();
                //填充登录成功后的返回值
                String userIdStr = String.valueOf(userId);
                BeanUtils.copyProperties(tokenInfo, result);
                result.setPermissions(permissionList);
                result.setRoles(roles);
                result.setLoginId(userIdStr);
                result.setUserId(userIdStr);
                result.setUserName(loginDTO.getUserName());
                result.setLoginDevice(LoginDeviceType.valueOf(loginDTO.getLoginType()).getName());
                return ApiResult.ok(result);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                StpUtil.logout(userId);
                return ApiResult.fail("登录异常，请联系管理查看原因");
            }
        }
        return ApiResult.fail(loginResult.getMessage());
    }

    @Override
    public ApiResult<String> logOut() {
        if (StpUtil.isLogin()) {
            StpUtil.logout();
        }
        return ApiResult.ok();
    }
}
