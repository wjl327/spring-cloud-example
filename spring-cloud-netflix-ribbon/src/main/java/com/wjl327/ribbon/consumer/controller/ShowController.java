package com.wjl327.ribbon.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ShowController {

    @Autowired
    private RestTemplate restTemplate;

    private AtomicInteger seq = new AtomicInteger(0);

//    @RequestMapping(value = "/show/servise/{serviceName}", method = RequestMethod.GET)
//    public Object sayHello(@PathVariable String serviceName) {
//        return discoveryClient.getInstances(serviceName);
//    }

    @RequestMapping(value = "/show/{name}", method = RequestMethod.GET)
    public Object showHello(@PathVariable String name) {
        return restTemplate.getForObject("http://spring-cloud-eureka-provider/hello/" + name, String.class);
    }

}