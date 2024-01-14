package cn.zeroable.cat4j.base.entity;

import cn.zeroable.cat4j.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import cn.zeroable.cat4j.entity.BasePO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 终端信息 POJO;
 *
 * @author : zeroable
 * @version : 2024-01-07 000:12:00
 * @since 0.0.1
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
public class OauthClientDetails extends BaseEntity implements Serializable, Cloneable {


    /**
     * 资源列表
     */
    private String resourceIds;

    /**
     * 客户端密钥
     */
    private String clientSecret;

    /**
     * 客户端密钥
     */
    private String openId;

    /**
     * 域
     */
    private String scope;

    /**
     * 认证类型
     */
    private String authorizedGrantTypes;

    /**
     * 重定向地址
     */
    private String webServerRedirectUri;

    /**
     * 角色列表
     */
    private String authorities;

    /**
     * token 有效期
     */
    private Integer accessTokenValidity;

    /**
     * 刷新令牌有效期
     */
    private Integer refreshTokenValidity;

    /**
     * 令牌扩展字段JSON
     */
    private String additionalInformation;

    /**
     * 是否自动放行
     */
    private Boolean autoApprove;

    @Override
    public OauthClientDetails clone() {
        return (OauthClientDetails) super.clone();
    }
}