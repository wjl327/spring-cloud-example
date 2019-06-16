package com.wjl327.eureka.provider.controller;

import com.wjl327.common.pojo.User;
import com.wjl327.eureka.provider.pojo.RetMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private AtomicInteger atomic = new AtomicInteger();
    private ConcurrentHashMap<Integer, User> concurrentHashMap = new ConcurrentHashMap<>();

    @RequestMapping("/register")
    public RetMsg register(String username, String password) {
        logger.info("Received register username:{} password:{}", username, password);
        int id = atomic.incrementAndGet();
        concurrentHashMap.put(id, new User(id, username, password));
        return RetMsg.Success;
    }

    @RequestMapping("/registerUser")
    public RetMsg registerUser(@RequestBody User user) {
        logger.info("Received register user:{}", user);
        int id = atomic.incrementAndGet();
        user.setId(id);
        concurrentHashMap.put(id, user);
        return RetMsg.Success;
    }


    @RequestMapping("/list")
    public List<User> list() {
        List<User> users = new ArrayList<>();
        users.addAll(concurrentHashMap.values());
        return users;
    }

}
