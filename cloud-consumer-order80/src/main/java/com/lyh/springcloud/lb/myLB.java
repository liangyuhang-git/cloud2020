package com.lyh.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class myLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;

        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("***next:" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> ServiceInstances) {
        int index = getAndIncrement()%ServiceInstances.size();
        return ServiceInstances.get(index);
    }
}
