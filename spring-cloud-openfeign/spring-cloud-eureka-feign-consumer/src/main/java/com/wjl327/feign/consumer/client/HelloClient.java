package com.wjl327.feign.consumer.client;

import com.wjl327.common.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient("spring-cloud-eureka-provider")
public interface HelloClient {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    String sayHello(@PathVariable("name") String name);

    @RequestMapping(value = "/user/register")
    String register1(@RequestParam("username") String username, @RequestParam("password") String password);

    @RequestMapping(value = "/user/register")
    String register2(@RequestParam Map<String, Object> user);

    @RequestMapping(value = "/user/registerUser", method = RequestMethod.POST)
    String registerUser(@RequestBody User user);

    @RequestMapping(value = "/user/list")
    String list();

}
