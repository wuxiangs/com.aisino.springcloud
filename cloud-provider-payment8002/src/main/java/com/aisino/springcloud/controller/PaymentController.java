package com.aisino.springcloud.controller;

import com.aisino.springcloud.entities.CommonResult;
import com.aisino.springcloud.entities.Payment;
import com.aisino.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author wuxiang
 * @date 2021/7/4 5:25 下午
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("****插入结果"+result);
        if (result>0){
            return new CommonResult(200,"插入数据库成功,端口："+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果"+payment);
        if (payment!=null){
            return new CommonResult(200,"查询成功,端口："+serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录，查询id="+id,null);
        }
    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLb(){

        return serverPort;
    }


    /**
     * OpenFeign超时演示
     * @return
     */
    @GetMapping(value="/payment/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }


}
