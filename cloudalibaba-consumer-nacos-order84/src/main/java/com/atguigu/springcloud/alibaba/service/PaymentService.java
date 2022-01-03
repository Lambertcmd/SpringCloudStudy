package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.entities.CommonResult;
import com.atguigu.springcloud.alibaba.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentService
 * @Description TODO
 * @Author Lambert
 * @Date 2021/12/21 20:53
 * @Version 1.0
 **/
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
//@FeignClient(value = "nacos-payment-provider")
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
