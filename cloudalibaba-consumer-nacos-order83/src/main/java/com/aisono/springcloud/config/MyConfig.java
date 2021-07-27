package com.aisono.springcloud.config;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuxiang
 * @date 2021/7/16 5:00 下午
 */
@Configuration
public class MyConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }
}
