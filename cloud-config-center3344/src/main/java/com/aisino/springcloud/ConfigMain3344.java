package com.aisino.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wuxiang
 * @date 2021/7/12 9:08 下午
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3344.class,args);
    }

}
