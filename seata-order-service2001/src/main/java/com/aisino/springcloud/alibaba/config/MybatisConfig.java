package com.aisino.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wuxiang
 * @date 2021/8/9 4:22 下午
 */
@Configuration
@MapperScan({"com.aisino.springcloud.alibaba.dao"})
public class MybatisConfig {
}
