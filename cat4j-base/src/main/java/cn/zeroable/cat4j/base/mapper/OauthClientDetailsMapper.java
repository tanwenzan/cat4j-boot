package cn.zeroable.cat4j.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import cn.zeroable.cat4j.base.entity.OauthClientDetailsPO;

 /**
 * 终端信息表;(cat4j_oauth_client_details)表数据库访问层
 *
 * @author : zeroable
 * @version : 2024-01-07 000:12:00
 * @since 0.0.1
 */
@Mapper
public interface OauthClientDetailsMapper extends BaseMapper<OauthClientDetailsPO> {
}