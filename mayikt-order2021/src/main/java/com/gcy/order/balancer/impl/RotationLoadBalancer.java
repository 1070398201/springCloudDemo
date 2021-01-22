package com.gcy.order.balancer.impl;

import com.gcy.order.balancer.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class RotationLoadBalancer implements LoadBalancer {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    @Override
    public ServiceInstance getSingleAddres(List<ServiceInstance> serviceInstances) {
        int index=atomicInteger.incrementAndGet() % serviceInstances.size();
        ServiceInstance serviceInstance = serviceInstances.get(index);
        return serviceInstance;
    }
}
