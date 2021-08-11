package com.aisino.springcloud.alibaba.service;

import com.aisino.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wuxiang
 * @date 2021/8/9 3:43 下午
 */
@FeignClient(value="seata-storage-service")
public interface StorageService {

    /**
     * 减库存
     * @param productId
     * @param count
     * @return
     */
    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,
                          @RequestParam("count") Integer count);


}
