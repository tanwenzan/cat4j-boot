package cn.zeroable.cat4j.base.mapper;

import cn.zeroable.cat4j.base.entity.MenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单表;(cat4j_menu)表数据库访问层
 *
 * @author : zeroable
 * @version : 2023-12-27 21:07:21
 * @since 0.0.1
 */
@Mapper
public interface MenuMapper extends BaseMapper<MenuEntity> {

     List<MenuEntity> getMenusByUserId(Long userId);

 }