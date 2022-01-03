package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentService
 * @Description TODO
 * @Author Lambert
 * @Date 2021/10/30 21:55
 * @Version 1.0
 **/
public interface PaymentService {
    //添加
    int create(Payment payment);

    //查询
    Payment getPaymentById(@Param("id") Long id);
}
