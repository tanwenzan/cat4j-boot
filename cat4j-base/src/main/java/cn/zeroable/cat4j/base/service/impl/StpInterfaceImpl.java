package cn.zeroable.cat4j.base.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限加载接口实现类.
 *
 * @author zeroable
 * @version 1/6/24 12:03 PM
 * @since 0.0.1
 */
@Component
public class StpInterfaceImpl implements StpInterface {
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<String> list = new ArrayList<String>();
        list.add("101");
        list.add("user.add");
        list.add("test");
        list.add("user.update");
        list.add("user.get");
        list.add("art.*");
        return list;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 本 list 仅做模拟，实际项目中要根据具体业务逻辑来查询角色
        List<String> list = new ArrayList<String>();
        list.add("admin");
        list.add("super-admin");
        return list;
    }
}
