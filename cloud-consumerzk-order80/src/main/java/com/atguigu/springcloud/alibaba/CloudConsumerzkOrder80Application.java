package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerzkOrder80Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudConsumerzkOrder80Application.class, args);
	}

}