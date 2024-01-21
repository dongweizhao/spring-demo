package com.example.spring.demo.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author weizhao.dong
 * @Date: 2020/9/3 上午10:12
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {


    /***
     *  路径匹配说明：https://lixh1986.iteye.com/blog/2435736
     *  拦截器配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //header进行拦截，针对用户web或者app请求拦截
//        registry.addInterceptor(headerInterceptor())
//                .excludePathPatterns("/boss/**", "/health/check", "/cex/boss/**", "/api/**", "/swagger-ui.html", "/error", "images/**", "/webjars/**", "/swagger-resources/**", "/manage/**", "/account/refreshByAccountNo", "/account/refreshByUtcUpdate")
//                .addPathPatterns("/**");
//		registry.addInterceptor(WebConfigManager.getSentinelWebInterceptor(null,null)).addPathPatterns("/**");
    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        // 配置序列化特性
//        FastJsonConfig config = new FastJsonConfig();
//        config.setSerializerFeatures(
//                SerializerFeature.WriteBigDecimalAsPlain, // 序列化BigDecimal为普通数字
//                SerializerFeature.WriteMapNullValue // 序列化空值
//        );
//        fastConverter.setFastJsonConfig(config);
//
//        // 将FastJSON的消息转换器添加到转换器列表
//        converters.add(fastConverter);
//    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedHeaders("*").allowedMethods("*")
                .allowedOrigins("*").allowCredentials(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }


}
