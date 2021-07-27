package com.aisono.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wuxiang
 * @date 2021/7/16 1:48 下午
 */
@RestController
@Slf4j
public class NacosOrderController {

    @Resource
    private RestTemplate restTemplate;


    @Value("${service-url.nacos-user-service}")
    private String serverURL;


    @GetMapping(value="/consumer/payment/nacos/{id}")
    public String getNacosPayment(@PathVariable("id") Integer id){
        return restTemplate.getForObject(serverURL+"/payment/nacos/"+id,String.class);
    }
}
