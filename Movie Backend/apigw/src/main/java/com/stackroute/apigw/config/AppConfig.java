package com.stackroute.apigw.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RouteLocator getRoutes(RouteLocatorBuilder builder){

        return builder.routes()
                .route( p-> p
                        .path("/auth-app-v1/**")
                        .uri("http://localhost:4444/*"))
                .route(p->p
                        .path("/product-app-v1/**")
                        .uri("http://localhost:5555/*"))
        .build();
    }
}
