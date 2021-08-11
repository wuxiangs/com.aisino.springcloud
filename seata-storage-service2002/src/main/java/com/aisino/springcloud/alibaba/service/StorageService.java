package com.aisino.springcloud.alibaba.service;

/**
 * @author wuxiang
 * @date 2021/8/10 2:51 下午
 */
public interface StorageService {

    /**
     * 减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId,Integer count);
}
