package com.aisino.springcloud.alibaba.service.impl;

import com.aisino.springcloud.alibaba.dao.AccountDao;
import com.aisino.springcloud.alibaba.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author wuxiang
 * @date 2021/8/10 3:36 下午
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER= LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    private AccountDao accountDao;


    /**
     * 扣除余额
     * @param userId
     * @param money
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("---->扣减余额开始");
        accountDao.decrease(userId,money);
        LOGGER.info("---->扣减余额结束");
    }
}
