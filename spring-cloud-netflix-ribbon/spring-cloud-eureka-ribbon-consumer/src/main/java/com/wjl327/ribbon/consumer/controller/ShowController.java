package com.wjl327.ribbon.consumer.controller;

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

    @RequestMapping(value = "/show/{name}", method = RequestMethod.GET)
    public Object show(@PathVariable String name) {
        String url = "http://spring-cloud-eureka-provider/hello/" + name;
        return restTemplate.getForObject(url, String.class);
    }

}
