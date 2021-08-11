package com.aisino.springcloud.alibaba.controller;

import com.aisino.springcloud.alibaba.domain.CommonResult;
import com.aisino.springcloud.alibaba.domain.Order;
import com.aisino.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuxiang
 * @date 2021/8/9 3:49 下午
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

}
