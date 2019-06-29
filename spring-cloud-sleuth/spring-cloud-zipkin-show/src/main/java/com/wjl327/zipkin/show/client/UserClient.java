package com.wjl327.zipkin.show.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("spring-cloud-zipkin-user")
public interface UserClient {

    @RequestMapping(value = "/user/getData", method = RequestMethod.GET)
    String getUserData(@RequestParam("name") String name);

}
