package com.aisino.springcloud.controller;

import com.aisino.springcloud.entities.CommonResult;
import com.aisino.springcloud.entities.Payment;
import com.aisino.springcloud.myhandler.ConsumerBlockHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiang
 * @date 2021/7/27 10:29 上午
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "HandException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试ok",new Payment(2001L,"serial001"));
    }

    public CommonResult HandException(BlockException e){
       return new CommonResult(444,e.getClass().getCanonicalName()+"\t服务不可用");
    }


    @GetMapping("/rateLimit/consumerBlockHandler")
    @SentinelResource(value = "consumerBlockHandler",
            blockHandlerClass = ConsumerBlockHandler.class,
            blockHandler = "handleException")
    public CommonResult consumerBlockHandler(){
        return new CommonResult(200,"客户自定义测试ok",new Payment(2001L,"serial003"));
    }





}
