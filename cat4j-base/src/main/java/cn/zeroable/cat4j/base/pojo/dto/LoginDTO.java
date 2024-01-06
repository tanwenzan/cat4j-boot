package cn.zeroable.cat4j.base.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

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

    @NotBlank(message = "登录用户名不能为空")
    private String userName;

    @NotBlank(message = "登录密码不能为空")
    private String passWord;

    public static LoginDTO byNameAndPwd(String userName, String passWord) {
        return new LoginDTO(userName, passWord);
    }
}
