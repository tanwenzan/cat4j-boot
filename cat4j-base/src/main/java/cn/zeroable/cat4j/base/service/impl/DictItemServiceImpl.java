package cn.zeroable.cat4j.base.service.impl;

import cn.zeroable.cat4j.base.mapper.DictItemMapper;
import cn.zeroable.cat4j.base.entity.DictItemEntity;
import cn.zeroable.cat4j.base.service.DictItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 字典明细;(cat4j_dict_item)表服务实现类
 *
 * @author : zeroable
 * @version : 2023-12-27 21:35:21
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItemEntity> implements DictItemService {
}