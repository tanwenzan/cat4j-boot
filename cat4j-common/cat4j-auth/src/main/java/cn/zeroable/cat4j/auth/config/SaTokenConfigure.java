package cn.zeroable.cat4j.auth.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.http.HttpStatus;
import cn.zeroable.cat4j.core.ApiResult;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录与权限拦截.
 *
 * @author zeroable
 * @version 1/5/24 11:24 PM
 * @see
 * @since 0.0.1
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    private static final String LOGIN_PATH = "/oauth2/token";

    private static final List<String> EXCLUDE_PATH_PATTERNS = new ArrayList<>();

    static {
        // 登录方法
        EXCLUDE_PATH_PATTERNS.add(LOGIN_PATH);
        EXCLUDE_PATH_PATTERNS.add("/error");
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(handle -> {

            // 登录校验 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
            SaRouter.match("/**")
                    .notMatch(EXCLUDE_PATH_PATTERNS)
                    .check(r -> StpUtil.checkLogin());
            // 权限校验
            SaRouter.match("/user/**", r -> StpUtil.checkPermission("user"));
        })).addPathPatterns("/**");
    }
}
