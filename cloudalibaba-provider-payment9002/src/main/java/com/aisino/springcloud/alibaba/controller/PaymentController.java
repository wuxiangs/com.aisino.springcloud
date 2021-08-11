package com.aisino.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiang
 * @date 2021/7/16 10:23 上午
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value="/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "Nacos register,ServerPort:"+serverPort+"\t id"+id;
    }
}
