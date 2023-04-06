package com.example.spring.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.spring.demo.po.User;
import com.example.spring.demo.mapper.UserMapper;
import com.example.spring.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spring.demo.vo.req.SelectListReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author w
 * @since 2023-04-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> selectList(SelectListReq req) {
        return userMapper.selectList(new QueryWrapper<User>().lambda()
                .eq(false,User::getUsername, req.getUsername()));
    }
}
