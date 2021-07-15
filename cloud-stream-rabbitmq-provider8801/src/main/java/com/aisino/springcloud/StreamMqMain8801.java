package com.aisino.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wuxiang
 * @date 2021/7/14 6:40 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMqMain8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMqMain8801.class,args);
    }
}

