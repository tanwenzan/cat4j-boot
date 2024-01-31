package cn.zeroable.cat4j.base.service;

import cn.zeroable.cat4j.base.entity.UserEntity;
import cn.zeroable.cat4j.base.vo.UserVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户表;(cat4j_user) 表服务接口
 *
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
public interface UserService extends IService<UserEntity> {
    /**
     * 通过用户id 获取 用户信息。
     *
     * @param userId 用户id
     * @return cn.zeroable.cat4j.base.vo.UserVO
     * @author tanwenzan
     * @date 1/13/24 5:04 PM
     */
    UserVO getUserById(Long userId);
}