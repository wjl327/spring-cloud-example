package com.wjl.spring.hystrix.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudEurekaFeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaFeignConsumerApplication.class, args);
    }



}
