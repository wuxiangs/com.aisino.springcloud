package com.aisino.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiang
 * @date 2021/7/23 11:08 上午
 */
@RestController
public class FlowLimitController {

    @GetMapping("/getA")
    public String getA(){
        return "****** A";
    }

    @GetMapping("/getB")
    public String getB(){
        return "****** B";
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){

        return "**** test testHotKey";
    }


    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "deal_testHotKey";
    }



}
