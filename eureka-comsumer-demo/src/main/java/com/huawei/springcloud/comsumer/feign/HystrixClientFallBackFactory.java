package com.huawei.springcloud.comsumer.feign;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallBackFactory implements FallbackFactory<ProviderClient> {
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallBackFactory.class);

    @Override
    public ProviderClient create(Throwable cause) {
        return new ProviderClient() {
            @Override
            public String producerDemo() {
                LOGGER.error("Fallback. Reason: ", cause);
                return "fallback, reason was: " + cause.getMessage();
            }
        };
    }
}
