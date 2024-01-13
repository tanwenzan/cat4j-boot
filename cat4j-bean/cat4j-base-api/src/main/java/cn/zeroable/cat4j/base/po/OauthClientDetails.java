package cn.zeroable.cat4j.base.po;

import com.baomidou.mybatisplus.annotation.TableField;
import cn.zeroable.cat4j.entity.BasePO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 终端信息表;
 *
 * @author : zeroable
 * @version : 2024-01-07 000:12:00
 * @since 0.0.1
 */
@TableName("cat4j_oauth_client_details")
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
public class OauthClientDetails extends BasePO implements Serializable, Cloneable {


    /**
     * 资源列表
     */
    @TableField("resource_ids")
    private String resourceIds;

    /**
     * 客户端密钥
     */
    @TableField("client_secret")
    private String clientSecret;

    /**
     * 客户端密钥
     */
    @TableField("client_secret")
    private String openId;

    /**
     * 域
     */
    @TableField("scope")
    private String scope;

    /**
     * 认证类型
     */
    @TableField("authorized_grant_types")
    private String authorizedGrantTypes;

    /**
     * 重定向地址
     */
    @TableField("web_server_redirect_uri")
    private String webServerRedirectUri;

    /**
     * 角色列表
     */
    @TableField("authorities")
    private String authorities;

    /**
     * token 有效期
     */
    @TableField("access_token_validity")
    private Integer accessTokenValidity;

    /**
     * 刷新令牌有效期
     */
    @TableField("refresh_token_validity")
    private Integer refreshTokenValidity;

    /**
     * 令牌扩展字段JSON
     */
    @TableField("additional_information")
    private String additionalInformation;

    /**
     * 是否自动放行
     */
    @TableField("auto_approve")
    private Boolean autoApprove;

    @Override
    public OauthClientDetails clone() {
        return (OauthClientDetails) super.clone();
    }
}