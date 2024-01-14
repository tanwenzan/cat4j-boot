package cn.zeroable.cat4j.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import cn.zeroable.cat4j.base.entity.OauthClientDetails;
import cn.zeroable.cat4j.base.mapper.OauthClientDetailsMapper;
import cn.zeroable.cat4j.base.service.OauthClientDetailsService;
/**
 * 终端信息表;(cat4j_oauth_client_details)表服务实现类
 *
 * @author : zeroable
 * @version : 2024-01-07 000:12:00
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class OauthClientDetailsServiceImpl extends ServiceImpl<OauthClientDetailsMapper, OauthClientDetails> implements OauthClientDetailsService {
}