package cn.zeroable.cat4j.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import cn.zeroable.cat4j.base.entity.OrganizationPO;

 /**
 * 组织架构;(cat4j_organization)表数据库访问层
 *
 * @author : zeroable
 * @version : 2023-12-27 21:32:21
 * @since 0.0.1
 */
@Mapper
public interface OrganizationMapper extends BaseMapper<OrganizationPO> {
}