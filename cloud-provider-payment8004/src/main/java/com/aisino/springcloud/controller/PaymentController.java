package com.aisino.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author wuxiang
 * @date 2021/7/7 3:47 下午
 */
@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/zk")
    public String paymentZk(){

        return "SpringCloud with zookeeper "+port+"\t"+ UUID.randomUUID().toString();
    }

}
