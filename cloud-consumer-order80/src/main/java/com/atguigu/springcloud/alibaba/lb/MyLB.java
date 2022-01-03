package com.atguigu.springcloud.alibaba.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MyLB
 * @Description TODO
 * @Author Lambert
 * @Date 2021/11/19 9:33
 * @Version 1.0
 **/
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
       int current;
       int next;
       do{
           current = this.atomicInteger.get();
           next = current >= 2147483647 ? 0 : current + 1;
       }while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("next::"+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstance) {
        int index = getAndIncrement() % serviceInstance.size();
        ServiceInstance instance = serviceInstance.get(index);
        return instance;
    }
}
