package cn.zeroable.cat4j.base.config;

import cn.dev33.satoken.fun.SaFunction;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.zeroable.cat4j.security.config.ISecurityConfigProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * 鉴权配置.
 *
 * @author zeroable
 * @version 2024/1/12 19:06
 * @since 0.0.1
 */
@Service
public class ISecurityConfigProviderImpl implements ISecurityConfigProvider {

    private static final String SUPER_ADMIN = "admin";

    @Override
    public String[] getLoginPathPatterns() {
        return null;
    }

    @Override
    public String[] getLoginNotMatch() {
        return null;
    }

    @Override
    public void addCheck(InterceptorRegistry registry) {
        // 权限校验
        SaRouter.match("/user/**", r -> filterIfIsSuperAdmin(() -> StpUtil.checkPermission("user")));
        SaRouter.match("/menu/**", r -> filterIfIsSuperAdmin(() -> StpUtil.checkPermission("menu")));
        SaRouter.match("/role/**", r -> filterIfIsSuperAdmin(() -> StpUtil.checkPermission("role")));
    }

    private void filterIfIsSuperAdmin(SaFunction fun) {
        if (StpUtil.hasRole(SUPER_ADMIN)) {
            return;
        }
        fun.run();
    }
}
