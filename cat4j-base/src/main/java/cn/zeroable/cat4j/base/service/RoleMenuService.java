package cn.zeroable.cat4j.base.service;

import cn.zeroable.cat4j.base.entity.RoleMenuEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 角色权限表;(cat4j_role_menu) 表服务接口
 *
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
public interface RoleMenuService extends IService<RoleMenuEntity> {

    List<String> getPermissionList(Object loginId);

}