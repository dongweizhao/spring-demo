package com.example.spring.demo.common.advice;

import com.alibaba.fastjson.JSONObject;
import com.example.spring.demo.common.bo.RespData;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:使用方式如下
 * public class SuccessResponseAdvice extends BaseResponseAdvice implements ResponseBodyAdvice<Object> {
 *
 *     @Override
 *     public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
 *         return super.supports(returnType, converterType);
 *     }
 *
 *
 *     @ResponseBody
 *     @Override
 *     public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
 *                                   Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
 *         return super.beforeBodyWrite(body, returnType, selectedContentType, selectedConverterType, request, response);
 *     }
 *
 * }
 * @author: dongweizhao
 * @date: 2020/9/4 上午9:31
 * @param: null
 * @return:
 */
@RestControllerAdvice(basePackages = "com.example.spring.demo.controller")
public class BaseResponseAdvice implements ResponseBodyAdvice<Object> {
    /**
     * @description:ignore cn.g2link.procli.consumer.advice
     * @author: dongweizhao
     * @date: 2020/9/3 上午11:18
     * @param: null
     * @return:
     */
    private static Map<Method, Boolean> ignore = new ConcurrentHashMap<>();

    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        Method method = returnType.getMethod();
        if (ignore.containsKey(method)) {
            return ignore.get(method);
        } else {
            boolean result = true;
            Annotation[] annotations = returnType.getMethodAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof IgnoreAdvice) {
                    result = false;
                    break;
                }
            }
            ignore.put(method, result);
            return result;
        }
    }


    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if (body instanceof RespData) {
            return body;
        } else if (selectedConverterType == StringHttpMessageConverter.class) {
            response.getHeaders().add("content-type", MediaType.APPLICATION_JSON_UTF8_VALUE);
            return JSONObject.toJSONString(RespData.success(body));
        }
        return RespData.success(body);

    }
}
