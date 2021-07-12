package com.aisino.springcloud.service.impl;

import com.aisino.springcloud.dao.PaymentDao;
import com.aisino.springcloud.entities.Payment;
import com.aisino.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuxiang
 * @date 2021/7/4 5:18 下午
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
