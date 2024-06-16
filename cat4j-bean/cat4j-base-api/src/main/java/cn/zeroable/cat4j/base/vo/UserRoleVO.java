package cn.zeroable.cat4j.base.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * 用户角色信息 view Object.
 *
 * @author zeroable
 * @version 2024/1/13 13:05
 * @since 0.0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleVO {

    private UserVO user;

    private List<RoleVO> roles;

    public static UserRoleVO of(UserVO user, List<RoleVO> roles) {
        return new UserRoleVO(user, roles);
    }
}
