package cn.zeroable.cat4j.base.config;

import cn.dev33.satoken.oauth2.config.SaOAuth2Config;
import cn.zeroable.cat4j.base.pojo.dto.LoginDTO;
import cn.zeroable.cat4j.base.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Sa-OAuth2 定制化配置.
 *
 * @author zeroable
 * @version 1/6/24 11:41 PM
 * @since 0.0.1
 */
@Configuration
@AllArgsConstructor
public class OAuthConfig {

    UserService userService;

    @Autowired
    public void setSaOAuth2Config(SaOAuth2Config cfg) {
        cfg.setDoLoginHandle((name, pwd) -> userService.login(LoginDTO.byNameAndPwd(name, pwd)));
        // 配置：确认授权时返回的View
        cfg.setConfirmView((clientId, scope) -> {
            String msg = "<p>应用 " + clientId + " 请求授权：" + scope + "</p>"
                    + "<p>请确认：<a href='/oauth2/doConfirm?client_id=" + clientId + "&scope=" + scope + "' target='_blank'> 确认授权 </a></p>"
                    + "<p>确认之后刷新页面</p>";
            return msg;
        });
    }
}
