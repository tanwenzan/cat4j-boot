package cn.zeroable.cat4j.base.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.zeroable.cat4j.base.pojo.dto.LoginDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import cn.zeroable.cat4j.base.entity.UserPO;
import cn.zeroable.cat4j.base.mapper.UserMapper;
import cn.zeroable.cat4j.base.service.UserService;

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
    public SaTokenInfo login(LoginDTO user) {

        return null;
    }
}