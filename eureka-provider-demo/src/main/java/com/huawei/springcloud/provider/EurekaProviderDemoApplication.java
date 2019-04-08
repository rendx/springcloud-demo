package com.huawei.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaProviderDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderDemoApplication.class, args);
    }

}
