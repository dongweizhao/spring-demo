package com.example.spring.demo.service;

import com.example.spring.demo.mapper.UserMapper;
import com.example.spring.demo.po.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.spring.demo.vo.req.SelectListReq;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author w
 * @since 2023-04-06
 */
public interface IUserService extends IService<User> {

    List<User> selectList(SelectListReq req);
}
