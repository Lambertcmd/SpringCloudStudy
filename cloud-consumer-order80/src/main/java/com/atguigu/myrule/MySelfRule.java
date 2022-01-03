package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MySelfRule
 * @Description TODO
 * @Author Lambert
 * @Date 2021/11/18 13:52
 * @Version 1.0
 **/
@Configuration
public class MySelfRule  {

    @Bean
    public IRule myRule(){
        return new RandomRule();//定义为随机
    }
}
