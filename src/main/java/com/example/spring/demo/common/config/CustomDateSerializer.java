package com.example.spring.demo.common.config;

import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
 
/**
 * 自定义Date序列化类
 */
public class CustomDateSerializer extends DateCodec {
    /**
     * 序列化方法（重写）
     *
     * @param serializer
     * @param object
     * @param fieldName
     * @param fieldType
     * @param features
     * @throws IOException
     */
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.getWriter();
        if (object == null) {
            out.writeNull();
            return;
        }
        //指定日期格式
        out.writeString(DateFormatUtils.format((Date) object, "yyyy-MM-dd HH:mm:ss"));
        return;
    }
}