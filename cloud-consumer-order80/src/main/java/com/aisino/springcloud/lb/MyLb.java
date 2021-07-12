package com.aisino.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wuxiang
 * @date 2021/7/9 9:40 上午
 */
@Component
public class MyLb implements LoadBalancer {

    private AtomicInteger atomicInteger=new AtomicInteger(0);


    public final int GetAndIncrement(){
        int current;
        int next;
        do {
            current=this.atomicInteger.get();
            next= current>=2147483647 ? 0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("***next:"+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index=GetAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
