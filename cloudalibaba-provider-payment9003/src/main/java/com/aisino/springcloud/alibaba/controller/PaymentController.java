package com.aisino.springcloud.alibaba.controller;

import com.aisino.springcloud.entities.CommonResult;
import com.aisino.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author wuxiang
 * @date 2021/7/27 3:24 下午
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long,Payment> hashMap=new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"zhangsan"));
        hashMap.put(2L,new Payment(2L,"lisi"));
    }


    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment=hashMap.get(id);
        CommonResult result=new CommonResult(200,"from server:"+serverPort,payment);
        return result;
    }
}
