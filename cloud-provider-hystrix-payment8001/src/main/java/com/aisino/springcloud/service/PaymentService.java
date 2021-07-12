package com.aisino.springcloud.service;

/**
 * @author wuxiang
 * @date 2021/7/9 5:06 下午
 */
public interface PaymentService {

    /**
     *hystrix正常访问，肯定OK
     * @param id
     * @return
     */
    String paymentInfo_OK(Integer id);

    /**
     *时间超时
     * @return
     */
    String paymentInfo_timeout(Integer id);

    /**
     * 服务熔断测试
     * @param id
     * @return
     */
    String paymentCircuitBreaker(Integer id);
}
