package com.wjl327.zipkin.show.controller;

import com.wjl327.zipkin.show.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private UserClient userClient;

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    @ResponseBody
    public String getData(String name) {
        int cost = new Random().nextInt(10);
        try {
            Thread.sleep(cost);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userClient.getUserData(name);
    }


}