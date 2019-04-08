package com.huawei.springcloud.comsumer.feign;

import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements ProviderClient {
    @Override
    public String producerDemo() {
        return "哎呀，出错了。。。";
    }
}
