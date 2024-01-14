package cn.zeroable.cat4j.base.service.impl;

import cn.zeroable.cat4j.base.entity.User;
import cn.zeroable.cat4j.base.mapper.UserMapper;
import cn.zeroable.cat4j.base.po.UserPO;
import cn.zeroable.cat4j.base.service.UserService;
import cn.zeroable.cat4j.base.vo.UserVO;
import cn.zeroable.cat4j.core.util.AssertUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户表;(cat4j_user)表服务实现类
 *
 * @author : zeroable
 * @version : 2023-12-27 21:34:21
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {

    @Override
    public UserVO getUserById(Long userId) {
        AssertUtil.notNull(userId, "用户id为空");
        UserPO user = getById(userId);
        AssertUtil.notNull(user, "用户id不存在：" + userId);
        return User.persistentObjectToViewObject(user);
    }
}