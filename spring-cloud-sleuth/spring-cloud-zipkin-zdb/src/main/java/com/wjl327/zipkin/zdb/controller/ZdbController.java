package com.wjl327.zipkin.zdb.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/zdb")
public class ZdbController {

    private Map<String, String> users;

    public ZdbController() {
        users = new HashMap<>();
        users.put("xiaoMi", "XiaoMi/21/S/160/student");
        users.put("xiaoHei", "XiaoHei/22/M/175/student");
        users.put("dowson", "Dowson/40/M/178/teacher");
    }

    @RequestMapping(value = "/getUserData", method = RequestMethod.GET)
    public String getUserData(String name) {
        int cost = new Random().nextInt(1000);
        try {
            Thread.sleep(cost);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return users.get(name);
    }

}
