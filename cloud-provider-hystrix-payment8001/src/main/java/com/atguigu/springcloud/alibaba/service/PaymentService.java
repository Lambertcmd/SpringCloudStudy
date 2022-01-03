package com.atguigu.springcloud.alibaba.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentService
 * @Description TODO
 * @Author Lambert
 * @Date 2021/11/22 14:30
 * @Version 1.0
 **/
@Service
@Slf4j
public class PaymentService {

    //服务降级
    public String paymentInfo_OK(Integer id){
        return "线程池:"+ Thread.currentThread().getName() + ",paymentInfo_OK,id：" + id;
    }

    //fallbackMethod:出错后会自动调用该属性标注好的方法
    //commandProperties:指定该方法执行的时间，若超过会报超时错误
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="5000")})
    public String paymentInfo_Timeout(Integer id){
//        try {
//            TimeUnit.MILLISECONDS.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "线程池:"+ Thread.currentThread().getName() + "paymentInfo_timeout" + id + "o(*￣▽￣*)ブ";
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池:"+ Thread.currentThread().getName() + "系统繁忙或运行异常，请稍后再试" + id + "/(ㄒoㄒ)/~~";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率打到多少后
    })//在10s内，十次请求出现60％的失败率时开启断路器
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }

}
