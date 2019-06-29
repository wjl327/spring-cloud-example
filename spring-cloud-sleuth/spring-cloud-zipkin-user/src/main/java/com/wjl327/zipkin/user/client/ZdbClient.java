package com.wjl327.zipkin.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("spring-cloud-zipkin-zdb")
public interface ZdbClient {

    @RequestMapping(value = "/zdb/getUserData", method = RequestMethod.GET)
    String getUserData(@RequestParam("name") String name);

}
