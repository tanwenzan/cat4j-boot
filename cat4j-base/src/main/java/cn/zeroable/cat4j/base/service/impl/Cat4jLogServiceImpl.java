package cn.zeroable.cat4j.base.service.impl;

import cn.zeroable.cat4j.base.mapper.Cat4jLogMapper;
import cn.zeroable.cat4j.base.entity.Cat4jLogEntity;
import cn.zeroable.cat4j.base.service.Cat4jLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 系统日志;(cat4j_log)表服务实现类
 *
 * @author : zeroable
 * @version : 2023-12-27 21:36:21
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class Cat4jLogServiceImpl extends ServiceImpl<Cat4jLogMapper, Cat4jLogEntity> implements Cat4jLogService {
}