package cn.zeroable.cat4j.config;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

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


    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(paginationInnerInterceptor());
        interceptor.addInnerInterceptor(optimisticLockerInnerInterceptor());
        return interceptor;
    }

    /**
     * 分页插件。
     *
     * @return com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
     * @author zeroable
     * @date 12/24/23 9:57 PM
     */
    private PaginationInnerInterceptor paginationInnerInterceptor() {
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
    public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor() {
        return new OptimisticLockerInnerInterceptor();
    }

    /**
     * 为了配置管理我把这段代码加入到了 MybatisPlusConfig 中。
     *
     * @return com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
     * @author zeroable
     * @date 02/04/24 9:57 PM
     */
    @Bean
    public DatabaseIdProvider databaseIdProvider() {
        VendorDatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties properties = new Properties();
        properties.put("Oracle","oracle");
        properties.put("MySQL","mysql");
        databaseIdProvider.setProperties(properties);
        return databaseIdProvider;
    }

}
