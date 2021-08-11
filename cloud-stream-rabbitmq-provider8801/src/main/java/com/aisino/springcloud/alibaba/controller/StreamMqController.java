package com.aisino.springcloud.alibaba.controller;

import com.aisino.springcloud.service.StreamMqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuxiang
 * @date 2021/7/14 6:48 下午
 */
@RestController
@Slf4j
public class StreamMqController {

    @Resource
    private StreamMqService service;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return service.send();
    }
}
