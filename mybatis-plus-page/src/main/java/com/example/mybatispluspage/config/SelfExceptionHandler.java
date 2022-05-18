package com.example.mybatispluspage.config;


import com.example.mybatispluspage.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


/**
 * 这个是一个controller异常处理器，全局的
 */
@Slf4j
@RestControllerAdvice()
public class SelfExceptionHandler {
    /**
     *请求方式异常
     * @param exception
     * @return
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public R requestMethodExceptionHandler(HttpServletRequest httpServletRequest, HttpRequestMethodNotSupportedException exception){
        log.error("异常消息{}, 异常类别{}", exception.getMessage(), exception.getClass());
        return R.error(HttpStatus.SC_METHOD_NOT_ALLOWED, "这个接口不能使用" + exception.getMethod() + "方法访问");
    }

    /**
     * 通用异常处理器
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public R commonExceptionHandler(Exception exception){
        log.error("异常消息{}, 异常类别shi{}", exception.getMessage(), exception.getClass());
        return R.error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "服务器内部异常");
    }
}
