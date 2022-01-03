package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.entities.CommonResult;
import com.atguigu.springcloud.alibaba.entities.Payment;
import com.atguigu.springcloud.alibaba.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author Lambert
 * @Date 2021/10/30 22:03
 * @Version 1.0
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*********插入结果:" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult(500, "插入数据库失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
//        System.out.println(payment.toString());
        if (payment != null) {
            return new CommonResult<>(200, "查询数据库成功,serverPort:" + serverPort, payment);
        } else {
            return new CommonResult<>(500, "没有对应记录，查询ID：" + id);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        //获取服务列表清单
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("****element:" + element);//****element:cloud-payment-service
            //****element:cloud-order-service
        }
        //获取服务列表清单中某个服务的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
            //CLOUD-PAYMENT-SERVICE	192.168.176.1	8002	http://192.168.176.1:8002
            //CLOUD-PAYMENT-SERVICE	192.168.176.1	8001	http://192.168.176.1:8001
        }
        return this.discoveryClient;
    }
    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //暂停几秒线程
        System.out.println("*****paymentFeignTimeOut from port: "+serverPort);
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }


}
