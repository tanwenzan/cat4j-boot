package cn.zeroable.cat4j.security.config;

import cn.dev33.satoken.fun.SaFunction;
import cn.dev33.satoken.fun.SaParamFunction;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.router.SaRouterStaff;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 登录与权限拦截.
 *
 * @author zeroable
 * @version 1/6/24 10:50 AM
 * @since 0.0.1
 */
@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    private static final String LOGIN_PATH = "/auth/login";

    private static final List<String> EXCLUDE_PATH_PATTERNS = new ArrayList<>();

    private static final String SUPER_ADMIN = "admin";

    private static final String NOT_LOGIN_MSG = "未登录";

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
            SaRouter.match("/**").notMatch(EXCLUDE_PATH_PATTERNS).check(r -> StpUtil.checkLogin());
            // 权限校验
            SaRouter.match("/user/**", r -> filterIfIsSuperAdmin(() -> StpUtil.checkPermission("user")));
            SaRouter.match("/menu/**", r -> filterIfIsSuperAdmin(() -> StpUtil.checkPermission("menu")));
            SaRouter.match("/role/**", r -> filterIfIsSuperAdmin(() -> StpUtil.checkPermission("role")));
        })).addPathPatterns("/**");
    }

    private void filterIfIsSuperAdmin(SaFunction fun) {
        if (StpUtil.hasRole(SUPER_ADMIN)) {
            return;
        }
        fun.run();
    }
}
