package cn.zeroable.cat4j.base.service;

import cn.zeroable.cat4j.base.vo.IconVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.zeroable.cat4j.base.entity.IconEntity;

/**
 * 图标表;(cat4j_icon) 表服务接口
 *
 * @author : tanwenzan
 * @version : 2024-02-07 10:08:10
 * @since 0.0.1
 */
public interface IconService extends IService<IconEntity> {

    IconVO iconList();
}