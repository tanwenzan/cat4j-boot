package cn.zeroable.cat4j.security.config;

import cn.dev33.satoken.fun.SaFunction;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录与权限拦截.
 *
 * @author zeroable
 * @version 1/6/24 10:50 AM
 * @since 0.0.1
 */
@Configuration
@AllArgsConstructor
public class SecurityConfig implements WebMvcConfigurer {

    private static final String LOGIN_PATH = "/auth/login";

    private static final List<String> EXCLUDE_PATH_PATTERNS = new ArrayList<>();

    private static final String[] LOGIN_PATH_PATTERNS = new String[]{"/**"};

    static {
        // 登录校验 -- 拦截所有路由，并排除/auth/login 用于开放登录
        EXCLUDE_PATH_PATTERNS.add(LOGIN_PATH);
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 提供对外扩展
        ISecurityConfigProvider iSecurityConfigProvider = SpringUtil.getBean(ISecurityConfigProvider.class);
        // 引入此模块都是为了鉴权，鉴权的前提是登录了，所以登录校验是必须的。
        String[] loginPathPatterns = getLoginPathPatterns(iSecurityConfigProvider);
        // 获取排除登录校验的路径合集。
        String[] loginNotMatch = getLoginNotMatch(iSecurityConfigProvider);
        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(handle -> {
            SaRouter.match(loginPathPatterns).notMatch(loginNotMatch).check(r -> StpUtil.checkLogin());
        })).addPathPatterns(loginPathPatterns);
        if (ObjectUtil.isNotEmpty(iSecurityConfigProvider)) {
            registry.addInterceptor(new SaInterceptor(handle -> iSecurityConfigProvider.addCheck(registry))).addPathPatterns(loginPathPatterns);
        }
    }

    /**
     * 根据扩展接口来获取排除登录校验的路径Patterns。
     *
     * @param iSecurityConfigProvider 扩展接口
     * @return java.lang.String[] 不需要登录校验的路径Patterns
     * @author tanwenzan
     * @date 2024/1/12 18:50
     */
    private String[] getLoginNotMatch(ISecurityConfigProvider iSecurityConfigProvider) {
        if (ObjectUtil.isEmpty(iSecurityConfigProvider)) {
            return EXCLUDE_PATH_PATTERNS.toArray(new String[0]);
        }
        String[] loginPathPatterns = iSecurityConfigProvider.getLoginNotMatch();
        if (loginPathPatterns == null) {
            loginPathPatterns = EXCLUDE_PATH_PATTERNS.toArray(new String[0]);
        }
        return loginPathPatterns;
    }

    /**
     * 根据扩展接口来获取需要登录校验的路径Patterns。
     *
     * @param iSecurityConfigProvider 扩展接口
     * @return java.lang.String[] 需要登录校验的路径Patterns
     * @author tanwenzan
     * @date 2024/1/12 18:50
     */
    private String[] getLoginPathPatterns(ISecurityConfigProvider iSecurityConfigProvider) {
        if (ObjectUtil.isEmpty(iSecurityConfigProvider)) {
            return LOGIN_PATH_PATTERNS;
        }
        String[] loginPathPatterns = iSecurityConfigProvider.getLoginPathPatterns();
        if (loginPathPatterns == null) {
            loginPathPatterns = LOGIN_PATH_PATTERNS;
        }
        return loginPathPatterns;
    }
}
