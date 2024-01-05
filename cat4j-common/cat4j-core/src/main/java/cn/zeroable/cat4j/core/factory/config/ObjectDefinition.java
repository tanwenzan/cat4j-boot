package cn.zeroable.cat4j.core.factory.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * 对象定义信息.
 * <br/> 基于{@link BeanDefinition beanDefinition}
 * 进行进一步封装，提供一些更加适用于多策略场景的方法.
 *
 * @author zeroable
 * @version 2023/8/21 9:06
 * @see BeanDefinition beanDefition
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
public class ObjectDefinition {

    private ObjectDefinition() {
    }

    /**
     * 对应的class信息
     */
    private Class<?> clazz;

    private BeanDefinition beanDefinition;

    private String name;

    public boolean isSingleton() {
        return beanDefinition.isSingleton();
    }

    public boolean isPrototype() {
        return beanDefinition.isPrototype();
    }
}
