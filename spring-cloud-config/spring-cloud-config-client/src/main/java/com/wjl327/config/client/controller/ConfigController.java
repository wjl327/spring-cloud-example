package com.wjl327.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

	@Value("${serverName}")
	String serverName;

	@RequestMapping(value = "/hello")
	public String hello(){
		return serverName;
	}
}