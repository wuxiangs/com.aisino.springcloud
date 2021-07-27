package com.aisino.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wuxiang
 * @date 2021/7/16 10:20 上午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentMain9002 {

    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentMain9002.class,args);
    }
}
