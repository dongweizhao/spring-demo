package com.example.spring.demo.service;

import com.example.spring.demo.bo.User;
import com.example.spring.demo.service.IUserService;
import com.example.spring.demo.vo.req.SelectListReq;
import com.google.common.collect.Lists;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 账户总额实现类
 * </p>
 *
 * @author w
 * @since 2023-04-06
 */
@Service
public interface IAccountService {

    /**
     * 充值操作
     * @param amount
     */
    void depositOrder(BigDecimal amount);

    /**
     * 提现操作
     * @param amount
     */
    void withdrawOrder(BigDecimal amount);


}
