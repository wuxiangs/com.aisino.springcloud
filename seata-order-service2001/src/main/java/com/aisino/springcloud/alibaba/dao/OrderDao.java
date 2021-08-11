package com.aisino.springcloud.alibaba.dao;

import com.aisino.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wuxiang
 * @date 2021/8/9 2:49 下午
 */
@Mapper
public interface OrderDao {


    /**
     * 新建订单
     * @param order
     */
    void create(Order order);

    /**
     * 更新订单
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId,@Param("status") Integer status);



}
