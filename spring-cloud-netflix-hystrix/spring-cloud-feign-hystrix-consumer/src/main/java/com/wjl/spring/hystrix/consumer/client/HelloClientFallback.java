package com.wjl.spring.hystrix.consumer.client;

import org.springframework.stereotype.Component;

@Component
public class HelloClientFallback implements HelloClient {

    @Override
    public String sayHello(String name) {
        return null;
    }

    @Override
    public String register(String username, String password) {
        return String.format("Fallback register %s fail.", username);
    }

    @Override
    public String list() {
        return "Fallback empty list.";
    }

}
