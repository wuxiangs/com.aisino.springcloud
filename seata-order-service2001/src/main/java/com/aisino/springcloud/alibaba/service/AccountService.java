package com.aisino.springcloud.alibaba.service;

import com.aisino.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author wuxiang
 * @date 2021/8/9 3:42 下午
 */
@FeignClient(value="seata-account-service")
public interface AccountService {


    /**
     * 调用账户微服务做扣减
     * @param userId
     * @param money
     * @return
     */
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId,
                          @RequestParam("money") BigDecimal money);

}
