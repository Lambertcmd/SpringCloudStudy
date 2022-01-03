package com.atguigu.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloudalibaba.service.SentinelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @Resource
    private SentinelService sentinelService;

    @GetMapping("/testA")
    public String testA() {
//        try {
//            TimeUnit.MILLISECONDS.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "------testA";
        return sentinelService.sentinelChain();
    }

    @GetMapping("/testB")
    public String testB() {
//        return "------testB";
        return sentinelService.sentinelChain();
    }

    /**
     * 测试降级策略：RT策略
     * @return
     */
    @GetMapping("/testD")
    public String testD()
    {
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");
        return "------testD";
    }

    /**
     * 测试降级策略：异常比例
     * @return
     */
    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 测试异常比例");
        int age = 10/0;
        return "------testE";
    }

    /**
     * 测试降级策略：异常数
     * @return
     */
    @GetMapping("/testF")
    public String testF()
    {
        log.info("testF 测试异常数");
        int age = 10/0;
        return "------testF 测试异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealHandler_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        int age = 10/0;
        return "----------testHotKey";
    }

    public String dealHandler_testHotKey(String p1, String p2, BlockException exception){
        return "dealHandler_testHotKey /(ㄒoㄒ)/~~";
    }




}