//package com.example.spring.demo.common.config;
//
//import com.alibaba.fastjson.serializer.SerializeConfig;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.serializer.ToStringSerializer;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Date;
//import java.util.Set;
//
///**
// * 前后端交互的时候，数据的ID字段采用的雪花ID，Long类型，返回给前端时，
// * 由于数值过大，会导致精度丢失，后面几位会变成0，这时候就需要把ID字段转成String类型的返回给前端页面。
// * 参考 https://blog.csdn.net/Vampire_1122/article/details/120062683
// */
//@Configuration
//public class CustomFastJsonConfig {
//    @Bean
//    FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
//        //1.需要定义一个convert转换消息的对象
//        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//
//        //2.添加fastJson的配置信息
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.WriteBigDecimalAsPlain, // 序列化BigDecimal为普通数字
//                SerializerFeature.WriteMapNullValue // 序列化空值
//        );
//        //3.设置Long为字符串
//        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
//        serializeConfig.put(Long.class, ToStringSerializer.instance);
//        serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
//        serializeConfig.put(Date.class, new CustomDateSerializer());
//        fastJsonConfig.setSerializeConfig(serializeConfig);
//
//        //4.在convert中添加配置信息.
//        converter.setFastJsonConfig(fastJsonConfig);
//        return converter;
//    }
//}
