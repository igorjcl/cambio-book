package com.igor.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(p ->
                        p.path("/get")
                                .uri("http://httpbin.org:80"))
                .route(p -> p.path("/cambio/**")
                        .uri("lb://cambio")
                )
                .route(p -> p.path("/book/**")
                        .uri("lb://book")
                )
                .build();
    }
}
