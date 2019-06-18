package com.wjl.spring.hystrix.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "spring-cloud-eureka-provider", fallback = HelloClientFallback.class)
public interface HelloClient {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    String sayHello(@PathVariable("name") String name);

    @RequestMapping(value = "/user/register")
    String register(@RequestParam("username") String username, @RequestParam("password") String password);

    @RequestMapping(value = "/user/list")
    String list();

}
