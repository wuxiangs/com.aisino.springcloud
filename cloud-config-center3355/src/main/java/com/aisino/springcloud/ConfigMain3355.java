package com.aisino.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wuxiang
 * @date 2021/7/13 9:10 上午
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3355.class,args);
    }
}
