package com.aisino.springcloud.service;

import com.aisino.springcloud.entities.CommonResult;
import com.aisino.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author wuxiang
 * @date 2021/8/5 10:40 上午
 */
@Component
public class PaymentFallBackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4444,"服务降级返回");
    }
}
