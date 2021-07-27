package com.aisino.springcloud.myhandler;

import com.aisino.springcloud.entities.CommonResult;
import com.aisino.springcloud.entities.Payment;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author wuxiang
 * @date 2021/7/27 10:52 上午
 */
public class ConsumerBlockHandler {

    public static CommonResult handleException(BlockException e){
       return new CommonResult(444,"客户自定义,global HandlerException----1",new Payment(2021L,"serial004"));
    }

    public static CommonResult handleException2(BlockException e){
        return new CommonResult(444,"客户自定义,global HandlerException----2",new Payment(2021L,"serial004"));
    }
}
