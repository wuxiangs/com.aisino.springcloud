package com.aisino.springcloud.service.imp;

import cn.hutool.core.util.IdUtil;
import com.aisino.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author wuxiang
 * @date 2021/7/9 5:06 下午
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    @Override
    public String paymentInfo_timeout(Integer id) {
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池： " +Thread.currentThread().getName()+"paymentInfo_timeout,id="+id+",耗时:"+2000;
    }

    @Override
    public String paymentInfo_OK(Integer id) {

        return "线程池： " +Thread.currentThread().getName()+"paymentInfo_OK,id="+id;
    }


    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池： " +Thread.currentThread().getName()+"paymentInfo_TimeoutHandler,id="+id+"\t"+"😂";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_Fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value="true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value="10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value="10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value="60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("id不能为负数");
        }

        String serialNumber= IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"调用成功,流水号："+serialNumber;
    }


    public String paymentCircuitBreaker_Fallback(@PathVariable("id") Integer id){

        return "id不能为负数,请稍后再试";
    }


}
