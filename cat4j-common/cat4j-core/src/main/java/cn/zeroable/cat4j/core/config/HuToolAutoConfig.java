package cn.zeroable.cat4j.core.config;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 使用 hutool 的 {@link SpringUtil SpringUtil.class} .
 *
 * @author zeroable
 * @version 2024/1/12 18:26
 * @see cn.hutool.extra.spring.SpringUtil
 * @since 0.0.1
 */
@Configuration
@Import(cn.hutool.extra.spring.SpringUtil.class)
public class HuToolAutoConfig {
}
