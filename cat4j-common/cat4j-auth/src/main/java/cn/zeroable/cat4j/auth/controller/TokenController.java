package cn.zeroable.cat4j.auth.controller;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.oauth2.logic.SaOAuth2Handle;
import cn.zeroable.cat4j.core.ApiResult;
import cn.zeroable.cat4j.web.config.handler.NotResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sa-OAuth2 Server端 控制器.
 *
 * @author zeroable
 * @version 1/6/24 10:56 AM
 * @since 0.0.1
 */
@RestController
public class TokenController {
    // 处理所有OAuth相关请求
    @RequestMapping("/oauth2/*")
    @NotResponseBody
    public Object request() {
        System.out.println("------- 进入请求: " + SaHolder.getRequest().getUrl());
        String url = SaHolder.getRequest().getUrl();
        if (url.endsWith("doLogin")) {
            return ApiResult.fail("暂不支持此方式登录");
        }
        return SaOAuth2Handle.serverRequest();
    }


}
