package cn.zeroable.cat4j.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import cn.zeroable.cat4j.base.entity.DictPO;
import cn.zeroable.cat4j.base.mapper.DictMapper;
import cn.zeroable.cat4j.base.service.DictService;
/**
 * 字典表;(cat4j_dict)表服务实现类
 *
 * @author : zeroable
 * @version : 2023-12-27 21:35:21
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class DictServiceImpl extends ServiceImpl<DictMapper, DictPO> implements DictService {
}