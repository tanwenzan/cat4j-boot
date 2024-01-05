package cn.zeroable.cat4j.web.config.handler;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这个作为一个无需额外处理返回结果的标记.
 * <br/> 当在 Controller 类或者方法上使用该注解，则表示该类（所有方法）或者该方法跳过全局接口结果返回处理.
 *
 * @author zeroable
 * @version 2024/1/4 15:37
 * @see
 * @since 0.0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface NotResponseBody {
}
