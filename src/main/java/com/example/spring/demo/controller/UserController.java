package com.example.spring.demo.controller;


import cn.g2link.user.cas.client.entity.UserInfoUtil;
import cn.g2link.user.cas.client.entity.UserInfoUtilNew;
import com.example.spring.demo.common.bo.RespData;
import com.example.spring.demo.vo.resp.FindAllParkResp;
import com.example.spring.demo.vo.resp.GetTenantInfoResp;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author w
 * @since 2023-04-06
 */
@RestController
@RequestMapping("/s-park/infra/base/park/")
@Slf4j
public class UserController {

    /**
     * 查询园区列表
     * 此接口会进行token校验
     */
    @RequestMapping(value = "/findAllPark", method = RequestMethod.GET)
    public RespData<List<FindAllParkResp>> selectList() {
        FindAllParkResp resp = FindAllParkResp.builder().orgCode("123").orgName("测试园区").build();
        log.info("登录用户信息, userID：{} userName:{}", UserInfoUtil.getUserId(), UserInfoUtil.getUserName());
        return RespData.success(Lists.newArrayList(resp));
    }

    /**
     * 获取租户信息
     * 此接口在@link {UCenterConfig}配置了不进行token校验
     *
     */
    @RequestMapping(value = "/geTenantInfo", method = RequestMethod.GET)
    public RespData<GetTenantInfoResp> geTenantInfo() {
        GetTenantInfoResp resp = GetTenantInfoResp.builder().name("测试租户").build();
        log.info("登录用户信息, userID：{} userName:{}", UserInfoUtilNew.getUserId(), UserInfoUtilNew.getUserName());
        return RespData.success(resp);
    }

}
