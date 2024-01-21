package com.example.spring.demo.controller;


import com.example.spring.demo.bo.User;
import com.example.spring.demo.common.bo.QueryResult;
import com.example.spring.demo.common.constants.ControllerConstants;
import com.example.spring.demo.service.IAccountService;
import com.example.spring.demo.service.IUserService;
import com.example.spring.demo.vo.req.SelectListReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 账户
 * </p>
 *
 * @author w
 * @since 2023-04-06
 */
@RestController
@RequestMapping(ControllerConstants.PATH_PREFIX + "/account")
public class AccountController {

    @Autowired
    IAccountService accountService;

    /**
     * 充值
     */
    @RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public void deposit(@RequestParam("amount") BigDecimal amount) {
        accountService.depositOrder(amount);
    }


    /**
     * 提现
     */
    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public void withdraw(@RequestParam("amount") BigDecimal amount) {
        accountService.withdrawOrder(amount);
    }


}
