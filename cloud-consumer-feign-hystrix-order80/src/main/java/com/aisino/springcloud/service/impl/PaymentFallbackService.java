package com.aisino.springcloud.service.impl;

import com.aisino.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author wuxiang
 * @date 2021/7/10 6:14 下午
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "paymentInfo_timeout";
    }
}
