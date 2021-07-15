package com.aisino.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wuxiang
 * @date 2021/7/14 8:04 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMessageMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMessageMain8803.class,args);
    }
}
