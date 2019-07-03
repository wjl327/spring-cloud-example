package com.wjl327.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudGatewayExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayExampleApplication.class, args);
    }

    @Bean
    public RouteLocator myRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/feign/**").filters(f->f.stripPrefix(1)).uri("lb://spring-cloud-eureka-feign-consumer"))
                .route(r -> r.path("/ribbon/**").filters(f->f.stripPrefix(1)).uri("lb://spring-cloud-eureka-ribbon-consumer"))
                .build();
    }

}
