package com.wjl327.eureka.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/hello/{string}", method = RequestMethod.GET)
    public String sayHello(@PathVariable String string) {
        return "Hello, " + string + ". My port is " + port;
    }

}
