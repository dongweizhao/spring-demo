package com.example.spring.demo.service;

import com.example.spring.demo.bo.User;
import com.example.spring.demo.vo.req.SelectListReq;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author w
 * @since 2023-04-06
 */
public interface IUserService  {

    List<User> selectList(SelectListReq req);
}
