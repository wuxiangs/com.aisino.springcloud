package com.aisino.springcloud.alibaba.service.impl;

import com.aisino.springcloud.alibaba.dao.StorageDao;
import com.aisino.springcloud.alibaba.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuxiang
 * @date 2021/8/10 2:51 下午
 */
@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER= LoggerFactory.getLogger(StorageServiceImpl.class);


    @Resource
    private StorageDao storageDao;


    /**
     * 减库存
     * @param productId
     * @param count
     */
    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("----->减库存开始");
        storageDao.decrease(productId,count);
        LOGGER.info("----->减库存结束");
    }
}
