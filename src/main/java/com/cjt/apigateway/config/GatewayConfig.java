package com.cjt.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("consultant", r -> r.path("/consultant/**")
//                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8081"))
                .route("service2", r -> r.path("/service2/**")
                        .uri("http://localhost:8082"))
                .build();
    }
}
