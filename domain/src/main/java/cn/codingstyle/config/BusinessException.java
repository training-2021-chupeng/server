package cn.codingstyle.config;

public class BusinessException extends RuntimeException {
    public BusinessException(String message, Throwable exception) {
        super(message, exception);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable exception) {
        super(exception);
    }
}
