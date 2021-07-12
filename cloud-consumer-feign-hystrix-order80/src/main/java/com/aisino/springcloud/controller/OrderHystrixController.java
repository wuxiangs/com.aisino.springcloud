package com.aisino.springcloud.controller;

import com.aisino.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@Slf4j
/**
 * 全局服务降级
 * @DefaultProperties(defaultFallback = "payment_global_fallbackMethod")
 */

/**
 * @author wuxiang
 * @date 2021/7/9 7:43 下午
 */
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping(value="/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){

        return paymentHystrixService.paymentInfo_OK(id);
    }

//    @HystrixCommand
    @GetMapping(value="/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id){

        return paymentHystrixService.paymentInfo_timeout(id);

    }

//    /**
//     * 服务降级全局设置
//     * @return
//     */
//    public String payment_global_fallbackMethod(){
//        return "程序出现异常,请10秒钟之后再试啊";
//    }

}
