package com.wjl.spring.eureka.consumer.controller;


import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ShowController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    private AtomicInteger seq = new AtomicInteger(0);

    @RequestMapping(value = "/serviceName/{serviceName}", method = RequestMethod.GET)
    public Object serviceName(@PathVariable String serviceName) {
        return discoveryClient.getInstances(serviceName);
    }

    @RequestMapping(value = "/show/{name}", method = RequestMethod.GET)
    public Object show(@PathVariable String name) {
        List<ServiceInstance> instances = discoveryClient.getInstances("spring-cloud-eureka-provider");
        String host = "";
        int port = 0;
        boolean match = false;
        for(int i = 0; i < instances.size(); i++) {
            ServiceInstance instance = instances.get(seq.getAndIncrement() % instances.size());
            host = instance.getHost();
            port = instance.getPort();
            if(StringUtils.isNotBlank(host) && port != 0) {
                match = true;
                break;
            }
        }
        if(!match){
            return "Not found server";
        }
        String url = "http://" + host + ":" + port + "/hello/" + name;
        return restTemplate.getForObject(url, String.class);
    }

}
