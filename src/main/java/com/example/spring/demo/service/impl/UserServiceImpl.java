package com.example.spring.demo.service.impl;

import com.example.spring.demo.bo.User;
import com.example.spring.demo.service.IUserService;
import com.example.spring.demo.vo.req.SelectListReq;
import com.google.common.collect.Lists;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author w
 * @since 2023-04-06
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private MeterRegistry registry;

    @Override
    public List<User> selectList(SelectListReq req) {
        return Lists.newArrayList(User.builder().age(20).id(1).username("张三").build());
    }
}
