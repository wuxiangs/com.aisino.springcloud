package com.aisino.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * @author wuxiang
 * @date 2021/8/10 3:35 下午
 */
public interface AccountService {

    /**
     * 扣余额
     * @param userId
     * @param money
     */
    void decrease(Long userId,BigDecimal money);
}
