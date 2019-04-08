package com.huawei.springcloud.comsumer.controller;

import com.huawei.springcloud.comsumer.feign.ProviderClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private ProviderClient providerClient;


    @RequestMapping("/consumer/demo1")
    @HystrixCommand(fallbackMethod = "hasError")
    public Object consumerDemo() {
        return restTemplate.getForObject("http://provider-demo/provider/demo", String.class);
    }

    @RequestMapping("/consumer/getInterfaceInfo")
    public void getInterfaceInfo() {
        ServiceInstance choose = loadBalancerClient.choose("provider-demo");
        System.out.println(choose.getPort());
    }

    @RequestMapping("/consumer/demo2")
    public String consumerFeignDemo() {
        return providerClient.producerDemo();
    }

    public String hasError(){
        return "哎呀，出错了。。。";
    }

}
