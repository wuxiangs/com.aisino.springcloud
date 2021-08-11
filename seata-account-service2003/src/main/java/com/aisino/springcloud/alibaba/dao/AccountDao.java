package com.aisino.springcloud.alibaba.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author wuxiang
 * @date 2021/8/10 3:28 下午
 */
@Mapper
public interface AccountDao {


    /**
     * 扣余额
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);



}
