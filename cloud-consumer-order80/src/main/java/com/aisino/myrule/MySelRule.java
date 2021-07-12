package com.aisino.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wuxiang
 * @date 2021/7/8 5:17 下午
 */
@Configuration
public class MySelRule {

    @Bean
    public IRule MyRule(){

        /**
         * 定义为随机
         */
        return new RandomRule();
    }
}
