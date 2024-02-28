package cn.zeroable.cat4j.base.service.impl;

import cn.zeroable.cat4j.base.vo.IconItemVO;
import cn.zeroable.cat4j.base.vo.IconVO;
import cn.zeroable.cat4j.core.util.BeanCovertUtil;
import cn.zeroable.cat4j.core.util.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import cn.zeroable.cat4j.base.entity.IconEntity;
import cn.zeroable.cat4j.base.mapper.IconMapper;
import cn.zeroable.cat4j.base.service.IconService;

import java.util.List;
import java.util.Map;

/**
 * 图标表;(cat4j_icon)表服务实现类
 *
 * @author : zeroable
 * @version : 2024-02-07 10:08:10
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class IconServiceImpl extends ServiceImpl<IconMapper, IconEntity> implements IconService {


    @Override
    public IconVO iconList() {
        List<IconEntity> list = list();
        Map<Integer, List<IconItemVO>> groupByType = CollectionUtil.groupList(list,
                (iconEntity -> BeanCovertUtil.copyProperties(iconEntity, IconItemVO.class)),
                ((iconEntity, iconItemVO) -> iconEntity.getType()));
        return new IconVO(groupByType);
    }

}