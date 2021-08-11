package com.aisino.springcloud.alibaba.controller;

import com.aisino.springcloud.alibaba.domain.CommonResult;
import com.aisino.springcloud.alibaba.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuxiang
 * @date 2021/8/10 2:55 下午
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;


    @RequestMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,
                          @RequestParam("count") Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功");
    }
}
