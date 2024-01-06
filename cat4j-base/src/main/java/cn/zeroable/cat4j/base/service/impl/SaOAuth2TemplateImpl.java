package cn.zeroable.cat4j.base.service.impl;

import cn.dev33.satoken.oauth2.logic.SaOAuth2Template;
import cn.dev33.satoken.oauth2.model.SaClientModel;

/**
 * 简要说明.
 * <br/> 详细说明.
 *
 * @author zeroable
 * @version 1/6/24 12:09 PM
 * @see
 * @since 0.0.1
 */

public class SaOAuth2TemplateImpl extends SaOAuth2Template {
    // 根据 id 获取 Client 信息
    @Override
    public SaClientModel getClientModel(String clientId) {
        // 此为模拟数据，真实环境需要从数据库查询
        if("1001".equals(clientId)) {
            return new SaClientModel()
                    .setClientId("1001")
                    .setClientSecret("aaaa-bbbb-cccc-dddd-eeee")
                    .setAllowUrl("*")
                    .setContractScope("test")
                    .setIsAutoMode(true);
        }
        return null;
    }

    // 根据ClientId 和 LoginId 获取openid
    @Override
    public String getOpenid(String clientId, Object loginId) {
        // 此为模拟数据，真实环境需要从数据库查询
        return "gr_SwoIN0MC1ewxHX_vfCW3BothWDZMMtx__";
    }
}
