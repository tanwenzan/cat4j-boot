package cn.zeroable.cat4j.core.util;

import cn.hutool.core.util.ObjectUtil;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.Set;

/**
 * 校验工具.
 *
 * @author zeroable
 * @version 2023/8/23 15:16
 * @since 0.0.1
 */
public class ValidateUtil {

    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 校验实体类。
     *
     * @param t 实体
     * @throws ConstraintViolationException 如果校验不通过
     * @author zeroable
     * @date 2023/8/23 15:19
     * @see jakarta.validation
     */
    public static <T> void validate(T t) {
        Set<ConstraintViolation<T>> constraintViolations = VALIDATOR.validate(t);
        throwConstraintViolationExceptionIfNeeded(constraintViolations);
    }


    /**
     * 通过组来校验实体类。
     *
     * @param t      实体类
     * @param groups 分组
     * @throws ConstraintViolationException 如果校验不通过
     * @author zeroable
     * @date 2023/8/23 15:22
     */
    public static <T> void validate(T t, Class<?>... groups) {
        Set<ConstraintViolation<T>> constraintViolations = VALIDATOR.validate(t, groups);
        throwConstraintViolationExceptionIfNeeded(constraintViolations);
    }

    /**
     * 如果有必要，则抛出 ConstraintViolationException。
     * <br/>如果校验失败，则需要抛出异常
     *
     * @param constraintViolations 校验失败结果集合
     * @throws ConstraintViolationException 校验结果集不为空
     * @author zeroable
     * @date 2023/8/23 15:23
     */
    private static <T> void throwConstraintViolationExceptionIfNeeded(Set<ConstraintViolation<T>> constraintViolations) {
        if (ObjectUtil.isNotEmpty(constraintViolations)) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}
