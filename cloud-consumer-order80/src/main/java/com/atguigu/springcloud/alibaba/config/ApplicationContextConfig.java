package com.atguigu.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationContextConfig
 * @Description TODO
 * @Author Lambert
 * @Date 2021/11/10 14:22
 * @Version 1.0
 **/
@Configuration
public class ApplicationContextConfig {

    /**
     * 配置RestTemplate远程调用
     */
    @Bean
//    @LoadBalanced  //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
