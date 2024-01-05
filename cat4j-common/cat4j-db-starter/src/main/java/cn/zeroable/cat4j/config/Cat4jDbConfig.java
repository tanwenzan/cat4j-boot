package cn.zeroable.cat4j.config;

import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 数据库配置.
 *
 * @author zeroable
 * @version 12/23/23 7:07 PM
 * @see
 * @since 0.0.1
 */
public class Cat4jDbConfig {

    /**
     * 分页插件。
     *
     * @return com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
     * @author zeroable
     * @date 12/24/23 9:57 PM
     */
    @Bean("paginationInnerInterceptor")
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        return new PaginationInnerInterceptor();
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
