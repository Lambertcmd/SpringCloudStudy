package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName StorageService
 * @Description TODO
 * @Author Lambert
 * @Date 2021/12/23 11:26
 * @Version 1.0
 **/
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
