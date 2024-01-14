package cn.zeroable.cat4j.base.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 登录成功返回的信息.
 *
 * @author zeroable
 * @version 1/13/24 11:19 PM
 * @since 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginResult {

    private String userId;

    /**
     * 账号
     */
    private String loginId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * Token Key
     */
    private String tokenName;

    /**
     * 用户Token
     */
    private String tokenValue;

    /**
     * 登录设备
     */
    private String loginDevice;

    /**
     * 暂无意义，扩展用
     */
    private String tag;

    /**
     * 角色列表
     */
    private List<String> roles;

    /**
     * 权限列表
     */
    private List<String> permissions;

}
