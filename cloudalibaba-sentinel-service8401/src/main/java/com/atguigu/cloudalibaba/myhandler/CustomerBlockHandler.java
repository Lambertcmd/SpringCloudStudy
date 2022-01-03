package com.atguigu.cloudalibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.entities.CommonResult;

/**
 * @ClassName CustomerBlockHandler
 * @Description TODO
 * @Author Lambert
 * @Date 2021/12/18 23:27
 * @Version 1.0
 **/
public class CustomerBlockHandler
{
    public static CommonResult handleException(BlockException exception){
        return new CommonResult(4444,"自定义的限流处理信息......CustomerBlockHandler----1");
    }
    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(4444,"自定义的限流处理信息......CustomerBlockHandler----2");
    }
}