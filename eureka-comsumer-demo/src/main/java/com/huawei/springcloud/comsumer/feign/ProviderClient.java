package com.huawei.springcloud.comsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
//@FeignClient(name = "provider-demo", fallback = HystrixClientFallback.class)
@FeignClient(name = "provider-demo", fallbackFactory = HystrixClientFallBackFactory.class)
public interface ProviderClient {

    @GetMapping(path = "/provider/demo")
    String producerDemo();

}
