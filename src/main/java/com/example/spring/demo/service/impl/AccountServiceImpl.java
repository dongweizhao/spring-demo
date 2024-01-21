package com.example.spring.demo.service.impl;

import com.example.spring.demo.bo.User;
import com.example.spring.demo.service.IAccountService;
import com.example.spring.demo.service.IUserService;
import com.example.spring.demo.vo.req.SelectListReq;
import com.google.common.collect.Lists;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 账户充值实现类
 */
@Service
@Slf4j
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private MeterRegistry registry;


    private Counter depositCounter; //入金笔数
    private Counter withdrawCounter; // 出金笔数
    private DistributionSummary depositAmountSummary; //入金金额
    private DistributionSummary withdrawAmountSummary; // 出金金额
    private BigDecimal balance = new BigDecimal(1000);

    @PostConstruct
    private void init() {
        depositCounter = registry.counter("deposit_counter", "currency", "btc");
        withdrawCounter = registry.counter("withdraw_counter", "currency", "btc");
        depositAmountSummary = registry.summary("deposit_amount", "currency", "btc");
        withdrawAmountSummary = registry.summary("withdraw_amount", "currency", "btc");
        Gauge.builder("balanceGauge", () -> balance)
                .tags("currency", "btc")
                .description("余额")
                .register(registry);
    }


    @Override
    // 充值操作
    public void depositOrder(BigDecimal amount) {
        log.info("depositOrder amount:{}", amount);
        try {
            //余额增加
            balance = balance.add(amount);
            //充值笔数埋点
            depositCounter.increment();
            //充值金额埋点
            depositAmountSummary.record(amount.doubleValue());

        } catch (Exception e) {
            log.info("depositOrder error", e);
        } finally {
            log.info("depositOrder result:{}", amount);
        }
    }

    @Override
    //提现操作
    public void withdrawOrder(BigDecimal amount) {
        log.info(" withdrawOrder amount:{}", amount);
        try {
            if (balance.subtract(amount).compareTo(BigDecimal.ZERO) < 0) {
                throw new Exception("提现金额不足，提现失败");
            }
            //余额减少
            balance = balance.subtract(amount);
            // 提现笔数埋点数据
            withdrawCounter.increment();
            // 提现金额埋点
            withdrawAmountSummary.record(amount.doubleValue());
        } catch (Exception e) {
            log.info("withdrawOrder error", e);
        } finally {
            log.info("withdrawOrder result:{}", amount);
        }
    }

}
