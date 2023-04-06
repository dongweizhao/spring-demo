package com.example.spring.demo.common.exception;

import com.example.spring.demo.common.bo.RespData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
*全局异常捕获
 * @author: dongweizhao
 * @date: 2020/9/4 上午9:29
 * @param: null
 * @return:
 */
@ControllerAdvice(basePackages = "com.example.spring.demo.controller")
@ResponseBody
@Slf4j
public class BaseGlobalExceptionHandler {



    /**
     * 全局业务异常捕获
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Object bizExceptionHandler(HttpServletRequest request, BizException e) {
        log.warn("catch bizException happened :url : {} ", request.getRequestURI(), e);
        /**
         * 返回业务异常中的码和说明
         */
        if (Objects.nonNull(e.getCode())) {
            return RespData.of(e.getCode());
        }
        return RespData.of(e.getErrCode(), e.getErrMsg(), null);
    }

    /**
     * 全局异常捕获       需要返回500
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Object exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("catch unexpected exception happened, url: {}, exception message : {}", request.getRequestURI(), e.getMessage(), e);
        return RespData.of(BizExceptionCode.SERVER_ERROR.getCode(), "系统异常，请联系管理员", null);
    }
}
