package com.aisino.springcloud.alibaba.controller;

import com.aisino.springcloud.alibaba.domain.CommonResult;
import com.aisino.springcloud.alibaba.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author wuxiang
 * @date 2021/8/10 3:27 下午
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;


    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,
                          @RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult(200,"余额扣除成功");
    }
}
