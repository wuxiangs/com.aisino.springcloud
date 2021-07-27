package com.aisino.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiang
 * @date 2021/7/17 5:53 下午
 */
@RestController
@Slf4j
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;


    @GetMapping(value="/config/getPort")
    public String getServerPort(){
        return configInfo;
    }
}
