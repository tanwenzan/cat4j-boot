package cn.zeroable.cat4j.base.pojo.dto;

import cn.hutool.json.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 登录实体类.
 *
 * @author zeroable
 * @version 1/6/24 9:40 AM
 * @see cn.zeroable.cat4j.base.service.UserService
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
@Slf4j
public class LoginDTO implements Serializable {

    /**
     * 账号
     */
    private String clientId;

    /**
     * 密钥
     */
    private String clientSecret;

    /**
     * 登录类型：1000=账号密码,etc.
     */
    private Integer loginType;

    /**
     * 登录设备类型：1000=PC,10010=APP,....
     */
    private Integer devType;

    /**
     * 其他扩展配置
     */
    private JSONObject config;
}
