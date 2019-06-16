package com.wjl327.feign.consumer.controller;

import com.wjl327.common.pojo.User;
import com.wjl327.feign.consumer.client.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class ShowController {

    @Autowired
    private HelloClient helloClient;


    @RequestMapping(value = "/show/{name}", method = RequestMethod.GET)
    public Object show(@PathVariable String name) {
        return helloClient.sayHello(name);
    }

    @RequestMapping(value = "/user/register1", method = RequestMethod.GET)
    public Object register1(String username, String password) {
        return helloClient.register1(username, password);
    }

    @RequestMapping(value = "/user/register2", method = RequestMethod.GET)
    public Object register2(String username, String password) {
        Map<String, Object> user = new HashMap<>();
        user.put("username", username);
        user.put("password", password);
        return helloClient.register2(user);
    }

    @RequestMapping(value = "/user/register3", method = RequestMethod.GET)
    public Object register3(String username, String password) {
        return helloClient.registerUser(new User(username, password));
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public Object list() {
        return helloClient.list();
    }


}
