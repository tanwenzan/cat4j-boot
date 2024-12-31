package cn.zeroable.cat4j.security.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.fun.SaFunction;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.zeroable.cat4j.core.ApiResult;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    private static final String LOGOUT_PATH = "/auth/logOut";

    private static final List<String> EXCLUDE_PATH_PATTERNS = new ArrayList<>();

    private static final String[] LOGIN_PATH_PATTERNS = new String[]{"/**"};

    static {
        // 登录校验 -- 拦截所有路由，并排除/auth/login 用于开放登录
        EXCLUDE_PATH_PATTERNS.addAll(Arrays.asList(LOGIN_PATH, LOGOUT_PATH));
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        Map<String, ISecurityConfigProvider> securityConfigProviders = SpringUtil.getBeansOfType(ISecurityConfigProvider.class);
        if (ObjectUtil.isNotEmpty(securityConfigProviders)) {
            securityConfigProviders.forEach((key, iSecurityConfigProvider) -> {
                // 引入此模块都是为了鉴权，鉴权的前提是登录了，所以登录校验是必须的。
                String[] loginPathPatterns = getLoginPathPatterns(iSecurityConfigProvider);
                // 获取排除登录校验的路径合集。
                if (ObjectUtil.isNotNull(iSecurityConfigProvider)) {
                    registry.addInterceptor(new SaInterceptor(handle -> iSecurityConfigProvider.addCheck(registry))).addPathPatterns(loginPathPatterns);
                }
            });
        }
    }

    /**
     * 根据扩展接口来获取排除登录校验的路径Patterns。
     *
     * @param iSecurityConfigProvider 扩展接口
     * @return java.lang.String[] 不需要登录校验的路径Patterns
     * @author zeroable
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
     * @author zeroable
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

    @Bean
    public SaServletFilter saServletFilter() {
        return new SaServletFilter().addInclude(LOGIN_PATH_PATTERNS).addExclude(LOGIN_PATH, LOGOUT_PATH)
                .setAuth(obj -> StpUtil.checkLogin())
                .setError(e -> ApiResult.fail(HttpStatus.UNAUTHORIZED.value(), "重新登录"))
                .setBeforeAuth(r -> {
                    SaHolder.getResponse().setHeader("Access-Control-Allow-Origin", "*")
                            .setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
                            .setHeader("Access-Control-Allow-Credentials", "true")
                            .setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers," +
                                    " Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method," +
                                    " Access-Control-Request-Headers");
                    ;
                });
    }
}
