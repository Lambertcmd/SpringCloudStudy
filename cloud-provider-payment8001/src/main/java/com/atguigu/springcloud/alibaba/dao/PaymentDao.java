package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentDao
 * @Description TODO
 * @Author Lambert
 * @Date 2021/10/30 21:21
 * @Version 1.0
 **/
@Mapper
public interface PaymentDao {
    //添加
    int create(Payment payment);

    //查询
    Payment getPaymentById(@Param("id") Long id);
}
