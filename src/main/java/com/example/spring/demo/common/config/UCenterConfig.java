package com.example.spring.demo.common.config;

import cn.g2link.user.cas.client.base.UcCasConfig;
import cn.g2link.user.cas.client.base.UcCasFilterFactoryBean;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author :  g2_user on 7/12/17.
 */
@Configuration
public class UCenterConfig {

    @Value("${cas.url}")
    private String casServerUrl;

    @Bean
    public UcCasFilterFactoryBean shiroFilter() {

        List<String> anonUrls = Lists.newArrayList();
        // 设置放行请求地址
        anonUrls.add("/s-park/infra/base/park/geTenantInfo");
        anonUrls.add("/captcha/**");
        List<String> half = Lists.newArrayList();

        UcCasConfig ucCasConfig = UcCasConfig.newInstance(casServerUrl,"ams", anonUrls,Lists.newArrayList(),half);
        UcCasFilterFactoryBean ucCasFilterFactoryBean = new UcCasFilterFactoryBean(ucCasConfig);
        return ucCasFilterFactoryBean;
    }

}
