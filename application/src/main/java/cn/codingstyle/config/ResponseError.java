package cn.codingstyle.config;

import org.springframework.http.ResponseEntity;

public class ResponseError {
    private Integer code;
    private String message;

    private ResponseError(String message) {
        this.code = 0;
        this.message = message;
    }

    public static ResponseError of(String message) {
        return new ResponseError(message);
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
