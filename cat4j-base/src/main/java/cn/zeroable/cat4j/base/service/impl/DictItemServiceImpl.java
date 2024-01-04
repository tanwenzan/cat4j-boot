package cn.zeroable.cat4j.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.leagsoft.report.core.mp.base.BaseServiceImpl;
import cn.zeroable.cat4j.base.entity.DictItemPO;
import cn.zeroable.cat4j.base.mapper.DictItemMapper;
import cn.zeroable.cat4j.base.service.DictItemService;
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
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItemPO> implements DictItemService {
}