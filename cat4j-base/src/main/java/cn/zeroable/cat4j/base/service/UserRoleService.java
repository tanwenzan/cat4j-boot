package cn.zeroable.cat4j.base.service;

import cn.zeroable.cat4j.base.entity.UserRoleEntity;
import cn.zeroable.cat4j.base.vo.UserRoleVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 用户角色表;(cat4j_user_role) 表服务接口
 *
 * @author : zeroable
 * @version : 2024-01-12 000:48:00
 * @since 0.0.1
 */
public interface UserRoleService extends IService<UserRoleEntity> {

    List<String> getRoleCodeByUserId(Long userId);

    UserRoleVO getUserRoleInfoByUserId(Long userId);

}