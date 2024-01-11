package cn.zeroable.cat4j.config;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * 数据库配置.
 *
 * @author zeroable
 * @version 12/23/23 7:07 PM
 * @since 0.0.1
 */
public class Cat4jDbConfig {

    @Value("${mybatis-plus.dbType:mysql}")
    private String dbTypeStr;

    /**
     * 多数据源标识
     */
    private static final String DYNAMIC = "dynamic";

    /**
     * 分页插件。
     *
     * @return com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
     * @author zeroable
     * @date 12/24/23 9:57 PM
     */
    @Bean("paginationInnerInterceptor")
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        // 如果是多数据源，就跳过设置数据源
        if (!StrUtil.equals(dbTypeStr.toLowerCase(), DYNAMIC)) {
            DbType type = DbType.getDbType(dbTypeStr);
            paginationInnerInterceptor.setDbType(type);
        }
        return paginationInnerInterceptor;
    }

    /**
     * 乐观锁插件。
     *
     * @return com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor
     * @author zeroable
     * @date 12/24/23 9:56 PM
     */
    @Bean("optimisticLockerInnerInterceptor")
    public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor() {
        return new OptimisticLockerInnerInterceptor();
    }
}
