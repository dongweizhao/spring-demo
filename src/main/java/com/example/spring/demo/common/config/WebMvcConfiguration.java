package com.example.spring.demo.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

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
