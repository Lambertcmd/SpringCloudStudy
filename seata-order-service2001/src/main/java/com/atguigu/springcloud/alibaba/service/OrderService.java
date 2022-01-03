package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.Order;

/**
 * @ClassName OrderService
 * @Description TODO
 * @Author Lambert
 * @Date 2021/12/23 11:19
 * @Version 1.0
 **/
public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);

}
