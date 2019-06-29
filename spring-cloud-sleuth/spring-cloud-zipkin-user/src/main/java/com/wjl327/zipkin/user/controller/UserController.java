package com.wjl327.zipkin.user.controller;


import com.wjl327.zipkin.user.client.ZdbClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ZdbClient zdbClient;

    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getData(String name) {
        int cost = new Random().nextInt(100);
        try {
            Thread.sleep(cost);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, Object> res = new HashMap<>();
        res.put("ServerPort", port);
        res.put("ResultData", zdbClient.getUserData(name));
        return res;
    }


}
