package cn.zeroable.cat4j.base.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.zeroable.cat4j.base.dto.LoginDTO;
import cn.zeroable.cat4j.base.service.AuthService;
import cn.zeroable.cat4j.base.vo.LoginResult;
import cn.zeroable.cat4j.core.ApiResult;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证接口.
 *
 * @author zeroable
 * @version 1/11/24 11:17 PM
 * @since 0.0.1
 */
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @RequestMapping("login")
    public ApiResult<LoginResult> login(@RequestBody @Validated LoginDTO loginDTO) {
        return authService.login(loginDTO);
    }

    @PostMapping("loginOut")
    public ApiResult<String> loginOut() {
        return authService.logOut();
    }
}
