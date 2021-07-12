package com.aisino.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author wuxiang
 * @date 2021/7/8 2:39 下午
 */
@RestController
@Slf4j
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/payment/consul")
    public String PaymentInfo(){
        return "springcloud with consul:"+serverPort+ UUID.randomUUID().toString();
    }
}
