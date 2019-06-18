package com.wjl.spring.hystrix.consumer.controller;

import com.wjl.spring.hystrix.consumer.client.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowController {

    @Autowired
    private HelloClient helloClient;

    @RequestMapping(value = "/show/{name}", method = RequestMethod.GET)
    public Object show(@PathVariable String name) {
        return helloClient.sayHello(name);
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public Object register1(String username, String password) {
        return helloClient.register(username, password);
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public Object list() {
        return helloClient.list();
    }


}
