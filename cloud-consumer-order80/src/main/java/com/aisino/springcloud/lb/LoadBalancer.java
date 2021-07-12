package com.aisino.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author wuxiang
 * @date 2021/7/9 9:35 上午
 */
public interface LoadBalancer {

    /**
     * 获取服务
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
