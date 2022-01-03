package com.atguigu.springcloud.alibaba.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @ClassName MyLogGatewayFilter
 * @Description TODO
 * @Author Lambert
 * @Date 2021/11/30 9:20
 * @Version 1.0
 **/
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*******come in MyLogGatewayFilter" + new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");//获取请求的参数是否含有uname
        if (uname == null){
            log.info("********用户为null，非法用户，/(ㄒoㄒ)/~~");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);//响应用户状态码为“不被接收”
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 决定加载过滤器的顺序
     * 返回值越小 优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
