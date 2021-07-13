package com.aisino.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiang
 * @date 2021/7/13 9:27 上午
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${spring.port}")
    private String serverPort;


    @GetMapping(value="/config/getPort")
    public String getServerPort(){
        System.out.println("张三");
        System.out.println("李四");
        System.out.println("王五");
        System.out.println("鬼脚七");
        return serverPort;
    }
}
