package cn.zeroable.cat4j.base.config;

import cn.dev33.satoken.stp.StpInterface;
import cn.zeroable.cat4j.base.service.RoleMenuService;
import cn.zeroable.cat4j.base.service.UserRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义权限加载接口实现类.
 *
 * @author zeroable
 * @version 1/12/24 12:06 AM
 * @since 0.0.1
 */
@Component
@AllArgsConstructor
@Slf4j
public class StpInterfaceImpl implements StpInterface {

    RoleMenuService roleMenuService;

    UserRoleService userRoleService;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return roleMenuService.getPermissionList(loginId);
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return userRoleService.getRoleCodeByUserId(Long.valueOf(String.valueOf(loginId)));
    }
}
