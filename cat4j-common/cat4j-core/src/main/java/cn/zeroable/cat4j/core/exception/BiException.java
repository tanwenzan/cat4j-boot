package cn.zeroable.cat4j.core.exception;

/**
 * 业务数据处理异常.
 * <br/> 此模块出现的可知异常均由此异常抛出.
 *
 * @author zeroable
 * @version 12/23/23 5:38 PM
 * @since 0.0.1
 */
public class BiException extends RuntimeException {
    public BiException() {
    }

    public BiException(String message) {
        super(message);
    }

    public BiException(String message, Throwable cause) {
        super(message, cause);
    }

    public BiException(Throwable cause) {
        super(cause);
    }

    public BiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
