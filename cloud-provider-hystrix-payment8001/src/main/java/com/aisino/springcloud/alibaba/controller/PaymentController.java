package com.aisino.springcloud.alibaba.controller;

import com.aisino.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuxiang
 * @date 2021/7/9 5:20 下午
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value="/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result=paymentService.paymentInfo_OK(id);
        log.info("result:"+result);
        return  result;
    }


    @GetMapping(value="/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {
        String result=paymentService.paymentInfo_timeout(id);
        log.info("result:"+result);
        return  result;
    }

    @GetMapping(value="/payment/hystrix/circuit/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id){

        String result=paymentService.paymentCircuitBreaker(id);

        return result;

    }
}
