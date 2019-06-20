package com.wjl327.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${serverName}")
    private String serverName;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Config value: " + serverName;
    }

}