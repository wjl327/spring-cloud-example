package com.wjl.spring.hystrix.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ShowController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "showFallback")
    @RequestMapping(value = "/show/{name}", method = RequestMethod.GET)
    public Object show(@PathVariable String name) {
        String url = "http://spring-cloud-eureka-provider/hello/" + name;
        return restTemplate.getForObject(url, String.class);
    }


    public Object showFallback(String name) {
        return "Fallback: hello, " + name;
    }

}
