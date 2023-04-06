package com.example.spring.demo.controller;


import com.example.spring.demo.common.bo.RespData;
import com.example.spring.demo.po.User;
import com.example.spring.demo.service.IUserService;
import com.example.spring.demo.vo.req.SelectListReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author w
 * @since 2023-04-06
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;
    /**
     * 入金成功
     */
    @RequestMapping(value = "/selectList", method = RequestMethod.GET)
    public RespData<List<User>> selectList() {
        return RespData.success(userService.selectList(new SelectListReq()));
    }

}
