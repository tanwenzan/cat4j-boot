package cn.zeroable.cat4j.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import cn.zeroable.cat4j.base.entity.MetaFieldEntity;
import cn.zeroable.cat4j.base.mapper.MetaFieldMapper;
import cn.zeroable.cat4j.base.service.MetaFieldService;
/**
 * 元字段;(cat4j_meta_field)表服务实现类
 *
 * @author : zeroable
 * @version : 2024-03-01 11:07:11
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class MetaFieldServiceImpl extends ServiceImpl<MetaFieldMapper, MetaFieldEntity> implements MetaFieldService {
}