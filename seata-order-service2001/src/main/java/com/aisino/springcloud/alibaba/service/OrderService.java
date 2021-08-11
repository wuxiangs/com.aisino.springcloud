package com.aisino.springcloud.alibaba.service;

import com.aisino.springcloud.alibaba.domain.Order;

/**
 * @author wuxiang
 * @date 2021/8/9 3:42 下午
 */
public interface OrderService {
    /**
     * 下订单
     * @param order
     */
    void create(Order order);
}
