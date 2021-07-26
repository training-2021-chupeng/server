package cn.codingstyle.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity defaultErrorHandler(
            HttpServletRequest request,
            HttpServletResponse response,
            Exception exception) {
        log.error("global error:\r\n url=" + request.getRequestURL(), exception);
        return new ResponseEntity(
                ResponseError.of("糟糕，发生未知异常，工程师正在紧急修复，请稍后重试！")
                , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity handlerException(BusinessException exception) {
        log.error("业务异常:\r\n", exception);
        return new ResponseEntity(ResponseError.of(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity handleArgumentInvalidException(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        List<String> errorMessages = fieldErrors.stream()
                .map(fieldError -> String.format("字段:%s:%s", fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        log.error("参数校验异常:\r\n", exception);
        return new ResponseEntity(ResponseError.of(String.join("|", errorMessages)), HttpStatus.BAD_REQUEST);
    }


}
