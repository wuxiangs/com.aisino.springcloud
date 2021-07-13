package com.aisino.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wuxiang
 * @date 2021/7/13 7:55 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigMain3366 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3366.class,args);
    }
}
