package com.aisino.springcloud.service;

import com.aisino.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author wuxiang
 * @date 2021/7/4 5:17 下午
 */
public interface PaymentService {
    /**
     * 创建支付订单
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 获取支付订单
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);
}
