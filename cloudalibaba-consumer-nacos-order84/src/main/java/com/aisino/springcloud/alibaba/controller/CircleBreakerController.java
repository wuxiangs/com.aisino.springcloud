package com.aisino.springcloud.alibaba.controller;

import com.aisino.springcloud.entities.CommonResult;
import com.aisino.springcloud.entities.Payment;
import com.aisino.springcloud.service.PaymentService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wuxiang
 * @date 2021/8/5 9:32 上午
 */

@RestController
@Slf4j
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String url;

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    /**
     * 无配置
     */
    //@SentinelResource(value = "fallback")
    /**
     * 只负责业务异常
     */
    //@SentinelResource(value = "fallback",fallback = "HandFallBack")
    /**
     * 只负责sentinel控制台配置违规
     */
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler")
    /**
     *
     */
    @SentinelResource(value = "fallback",blockHandler = "blockHandler",fallback = "HandFallBack",exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {

        CommonResult<Payment> result = restTemplate.getForObject(url + "/paymentSQL/" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException 非法参数异常");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException 该ID没有对应的数据，空指针异常");
        }
        return result;
    }

        public CommonResult HandFallBack(@PathVariable("id") Long id,Throwable e){
        Payment payment=new Payment(id,"null");
        return new CommonResult(444,"兜底异常 HandFallBack"+e.getMessage(),payment);
    }
    public CommonResult blockHandler(@PathVariable("id") Long id,BlockException e) {
        Payment payment=new Payment(id,"null");
        return new CommonResult(444,"兜底异常 HandFallBack"+e,payment);
    }


    /**
     * =======feign
     */
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }


}
