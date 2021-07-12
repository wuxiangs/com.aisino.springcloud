package com.aisino.springcloud.service;

import com.aisino.springcloud.entities.CommonResult;
import com.aisino.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wuxiang
 * @date 2021/7/9 2:02 下午
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     * 创建支付订单
     * @param payment
     * @return
     * public int create(Payment payment);
     */


    /**
     * 获取支付订单
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * feign超时演示
     * @return
     */
    @GetMapping(value="/payment/timeout")
    String paymentFeignTimeOut();

}
