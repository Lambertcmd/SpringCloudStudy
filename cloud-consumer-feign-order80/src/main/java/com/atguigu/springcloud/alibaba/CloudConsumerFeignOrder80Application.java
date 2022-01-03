package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName CloudConsumerFeignOrder80
 * @Description TODO
 * @Author Lambert
 * @Date 2021/11/22 9:15
 * @Version 1.0
 **/
@SpringBootApplication
@EnableFeignClients
public class CloudConsumerFeignOrder80Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeignOrder80Application.class, args);
    }
}
