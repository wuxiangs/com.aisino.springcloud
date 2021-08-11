package com.aisino.springcloud.service;

import com.aisino.springcloud.entities.CommonResult;
import com.aisino.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wuxiang
 * @date 2021/8/5 10:37 上午
 */
@FeignClient(value="nacos-provider-payment",fallback = PaymentFallBackService.class)
public interface PaymentService {

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
