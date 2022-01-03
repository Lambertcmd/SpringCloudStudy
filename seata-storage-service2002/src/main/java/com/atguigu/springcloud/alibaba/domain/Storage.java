package com.atguigu.springcloud.alibaba.domain;

import lombok.Data;

/**
 * @ClassName Storage
 * @Description TODO
 * @Author Lambert
 * @Date 2021/12/24 10:44
 * @Version 1.0
 **/
@Data
public class Storage {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}