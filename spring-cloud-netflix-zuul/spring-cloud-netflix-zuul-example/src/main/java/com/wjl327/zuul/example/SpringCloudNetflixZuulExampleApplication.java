package com.wjl327.zuul.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
@EnableEurekaClient
public class SpringCloudNetflixZuulExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNetflixZuulExampleApplication.class, args);
    }

}
