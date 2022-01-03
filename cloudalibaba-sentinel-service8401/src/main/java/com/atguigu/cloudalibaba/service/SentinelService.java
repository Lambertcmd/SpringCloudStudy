package com.atguigu.cloudalibaba.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName SentinelService
 * @Description TODO
 * @Author Lambert
 * @Date 2021/12/17 18:42
 * @Version 1.0
 **/
@Service
@Slf4j
public class SentinelService {

    @SentinelResource("sentinelChain")
    public String sentinelChain(){
        log.info("测试sentinel流控模式 —— 链路模式");
        return "Sentinel Mode - Chain";
    }
}
