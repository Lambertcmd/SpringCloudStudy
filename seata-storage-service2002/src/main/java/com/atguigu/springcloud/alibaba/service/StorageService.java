package com.atguigu.springcloud.alibaba.service;

/**
 * @ClassName StorageService
 * @Description TODO
 * @Author Lambert
 * @Date 2021/12/24 10:54
 * @Version 1.0
 **/
public interface StorageService {
    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId,Integer count);
}
