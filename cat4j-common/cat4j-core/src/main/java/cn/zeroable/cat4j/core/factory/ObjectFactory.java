package cn.zeroable.cat4j.core.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import java.util.List;

/**
 * 对象工厂类.
 * <br/> 在 Spring IOC 工厂的基础上进行扩充，满足某场景下可能存在多种方式（策略）.
 * <br/> 这种方式可以满足开闭原则，如果新建一种策略，只需要新增，而无需修改。
 * <br/> 传统匹配策略方式：
 * <pre>
 *     public Service getService(String type){
 *         if("api".equals(type)) {
 *             // doSomething...
 *             return aPIService;
 *         }else if("db".equals(type)){
 *             // doSomething...
 *             return dBService;
 *         }
 *         // etc.
 *         return otherService;
 *     }
 * </pre>
 * <br/> 使用此方式：
 * <pre>
 *     public Service getService(String type){
 *         // 一行搞定，后续添加类型，工厂会自动识别并处理。
 *         // 判断逻辑
 *         return objectFactory.getObject(type);
 *     }
 * </pre>
 *
 * @author tanwenzan
 * @version 2023/8/18 16:57
 * @since 0.0.1
 */
public interface ObjectFactory<S extends Type<T>, T> {

    /**
     * 通过类型获取对象。
     *
     * @param type 类型
     * @return S 对象
     * @throws BeansException                 – 如果对象没有被创建
     * @throws NoSuchBeanDefinitionException  – 如果该对象的 BeanDefinition 不存在
     * @throws BeanNotOfRequiredTypeException – 如果 bean 不是所需的类型
     * @author tanwenzan
     * @date 2023/8/18 17:09
     */
    S getObject(T type) throws BeansException;

    /**
     * 是否存在该类型的对象实例。
     *
     * @param type 执行类型
     * @return boolean 是否存在具有给定 类型的 对象实例
     * @author tanwenzan
     * @date 2023/8/18 17:13
     */
    boolean containsObject(T type);

    /**
     * 该对象生成方式是否是单例。
     *
     * @param type 类型
     * @return boolean 如果该类型的对象是单例，返回 <code>true</code> , 反之返回 <code>false</code> .
     * @throws NoSuchBeanDefinitionException – 如果不存在给定类型的 对象
     * @date 2023/8/18 17:16
     * @see org.springframework.context.annotation.Scope Scope(spring bean 作用域)
     */
    boolean isSingleton(T type) throws NoSuchBeanDefinitionException;

    /**
     * 该对象生成方式是否是原型。
     *
     * @param type 类型
     * @return boolean boolean 如果该类型的对象是原型，返回 <code>true</code> , 反之返回 <code>false</code> .
     * @throws NoSuchBeanDefinitionException – 如果不存在给定类型的 对象
     * @author tanwenzan
     * @date 2023/8/18 17:19
     * @see org.springframework.context.annotation.Scope Scope#(spring bean 作用域)
     */


    /**
     * 获取所有类型。
     * <br/> 此方法一般是在需要获取该场景下所有的策略类型，比如前端需要渲染策略类型，那么可以提供一个接口返回数据，而不是采用硬编码的方式。
     *
     * @return java.util.List<T> 返回所有类型
     * @author tanwenzan
     * @date 2023/8/21 10:44
     */
    List<T> types();
}
