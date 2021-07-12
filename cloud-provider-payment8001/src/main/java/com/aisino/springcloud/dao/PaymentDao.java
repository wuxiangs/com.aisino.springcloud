package com.aisino.springcloud.dao;

import com.aisino.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wuxiang
 * @date 2021/7/4 4:48 下午
 */
@Mapper
public interface PaymentDao {

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
