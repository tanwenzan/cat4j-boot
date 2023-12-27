package cn.zeroable.cat4j.core.factory;

import cn.hutool.extra.spring.SpringUtil;
import cn.zeroable.cat4j.core.factory.config.ObjectDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 对象工厂抽象类.
 *
 * @author tanwenzan
 * @version 2023/8/18 17:22
 * @see ObjectFactory
 * @since 0.0.1
 */
@Slf4j
public abstract class AbstractObjectFactory<S extends Type<T>, T> implements ObjectFactory<S, T> {

    protected final Map<T, ObjectDefinition> objectMap;

    public AbstractObjectFactory(Map<String, S> beansOfType) {
        int size = (int) (beansOfType.size() / 0.75f + 1);
        objectMap = new ConcurrentHashMap<>(size);
        ConfigurableListableBeanFactory configurableBeanFactory = SpringUtil.getConfigurableBeanFactory();
        beansOfType.forEach((name, bean) -> {
            if (!filterBean(name, bean)) {
                objectMap.put(bean.getType(), new ObjectDefinition(bean.getClass(),
                        configurableBeanFactory.getBeanDefinition(name), name));
            }
        });
        processBeansOfTypeIfNeeded(beansOfType);
    }

    /**
     * 过滤bean。
     * <br/>根据不同场景可能存在一些复杂的业务逻辑，需要对bean进行过滤，可交由子类进行实现。
     *
     * @param name bean名称
     * @param bean bean实例
     * @return boolean 如果不需要此bean，则返回true，反之返回false
     * @author tanwenzan
     * @date 2023/8/30 11:24
     */

    protected boolean filterBean(String name, S bean) {
        return false;
    }

    /**
     * 处理BeansOfType。
     * <br/>如果子类有需要，则子类可以重写此方法
     *
     * @param beansOfType 所有的Beans
     * @author tanwenzan
     * @date 2023/8/21 11:09
     */
    protected void processBeansOfTypeIfNeeded(Map<String, S> beansOfType) {
    }

    /**
     * 断言类型。
     * <br/>如果不存在此类型的BeanDefinition时进行断言
     *
     * @param type 类型
     * @return com.leagsoft.report.core.factory.config.ObjectDefinition
     * @throws NoSuchBeanDefinitionException 如果 不存在这样类型的BeanDefinition时抛出
     * @author tanwenzan
     * @date 2023/8/30 11:27
     */
    protected ObjectDefinition assertByType(T type) {
        if (!objectMap.containsKey(type)) {
            throw new NoSuchBeanDefinitionException("不存在此类型的BeanDefinition :" + type);
        }
        return objectMap.get(type);
    }

    @Override
    public S getObject(T type) throws BeansException {
        ObjectDefinition objectDefinition = assertByType(type);
        return SpringUtil.getBean(objectDefinition.getName());
    }

    @Override
    public boolean containsObject(T type) {
        return objectMap.containsKey(type);
    }

    @Override
    public boolean isSingleton(T type) throws NoSuchBeanDefinitionException {
        ObjectDefinition objectDefinition = assertByType(type);
        return objectDefinition.isSingleton();
    }

    @Override
    public boolean isPrototype(T type) throws NoSuchBeanDefinitionException {
        ObjectDefinition objectDefinition = assertByType(type);
        return objectDefinition.isPrototype();
    }

    @Override
    public List<T> types() {
        return objectMap.keySet().stream().toList();
    }
}
