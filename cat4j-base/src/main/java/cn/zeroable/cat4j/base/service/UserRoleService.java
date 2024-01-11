package cn.zeroable.cat4j.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.zeroable.cat4j.base.entity.UserRolePO;

import java.util.List;

/**
 * 用户角色表;(cat4j_user_role) 表服务接口
 *
 * @author : tanwenzan
 * @version : 2024-01-12 000:48:00
 * @since 0.0.1
 */
public interface UserRoleService extends IService<UserRolePO> {

    List<String> getRoleCodeByUserId(Long userId);

}