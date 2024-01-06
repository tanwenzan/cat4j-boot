package cn.zeroable.cat4j.base.service.impl;

import cn.dev33.satoken.oauth2.logic.SaOAuth2Template;
import cn.dev33.satoken.oauth2.model.SaClientModel;
import cn.zeroable.cat4j.base.entity.OauthClientDetailsPO;
import cn.zeroable.cat4j.base.service.OauthClientDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 简要说明.
 * <br/> 详细说明.
 *
 * @author zeroable
 * @version 1/6/24 12:09 PM
 * @see
 * @since 0.0.1
 */
@Component
@AllArgsConstructor
@Slf4j
public class SaOAuth2TemplateImpl extends SaOAuth2Template {

    OauthClientDetailsService oauthClientDetailsService;

    // 根据 id 获取 Client 信息
    @Override
    public SaClientModel getClientModel(String clientIdStr) {
        long clientId;
        try {
            clientId = Long.parseLong(clientIdStr);
        } catch (Exception e) {
            log.error("clientId 转换异常：" + clientIdStr);
            return null;
        }
        OauthClientDetailsPO oauthClientDetails = oauthClientDetailsService.getById(clientId);
        if (oauthClientDetails != null) {
            return new SaClientModel()
                    .setClientId(oauthClientDetails.getId() + "")
                    .setClientSecret(oauthClientDetails.getClientSecret())
                    .setAllowUrl("*")
                    .setContractScope(oauthClientDetails.getScope())
                    .setIsAutoMode(true);
        }
        return null;
    }

    // 根据ClientId 和 LoginId 获取openid
    @Override
    public String getOpenid(String clientIdStr, Object loginId) {
        long clientId;
        try {
            clientId = Long.parseLong(clientIdStr);
        } catch (Exception e) {
            log.error("clientId 转换异常：" + clientIdStr);
            return null;
        }
        OauthClientDetailsPO oauthClientDetails = oauthClientDetailsService.getById(clientId);
        if (oauthClientDetails != null) {
            return oauthClientDetails.getOpenId();
        }
        return null;
    }
}
