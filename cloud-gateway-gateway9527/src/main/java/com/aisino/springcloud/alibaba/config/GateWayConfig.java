package com.aisino.springcloud.alibaba.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wuxiang
 * @date 2021/7/12 3:50 下午
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("route_path",r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return  routes.build();
    }
}
