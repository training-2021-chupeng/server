package cn.codingstyle.config;

public class DBErrorException extends RuntimeException {
    public DBErrorException(String message, Throwable exception) {
        super(message, exception);
    }

    public DBErrorException(String message) {
        super(message);
    }

    public DBErrorException(Throwable exception) {
        super(exception);
    }
}
