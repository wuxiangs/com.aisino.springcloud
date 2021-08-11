package com.aisino.springcloud.alibaba.service.impl;

import com.aisino.springcloud.alibaba.dao.OrderDao;
import com.aisino.springcloud.alibaba.domain.Order;
import com.aisino.springcloud.alibaba.service.AccountService;
import com.aisino.springcloud.alibaba.service.OrderService;
import com.aisino.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuxiang
 * @date 2021/8/9 3:45 下午
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "seata-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        /**
         * 新建订单
         */
        log.info("----->开始新建订单");
        orderDao.create(order);

        /**
         * 扣减库存
         */
        log.info("----->订单微服务开始调用库存,做扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存,做扣减end");

        /**
         * 扣减账户
         */
        log.info("----->订单微服务开始调用账户,做扣减");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户,做扣减end");

        /**
         * 修改订单状态
         */
        log.info("----->修改订单状态");
        orderDao.update(order.getUserId(),0);
        log.info("----->修改订单状态end");

        log.info("下订单结束");
    }
}
