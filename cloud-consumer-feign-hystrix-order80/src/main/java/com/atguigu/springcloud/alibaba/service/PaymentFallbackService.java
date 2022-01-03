package com.atguigu.springcloud.alibaba.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName PaymentFallbackService
 * @Description TODO
 * @Author Lambert
 * @Date 2021/11/23 14:45
 * @Version 1.0
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_OK, o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_timeout, o(╥﹏╥)o";
    }
}
