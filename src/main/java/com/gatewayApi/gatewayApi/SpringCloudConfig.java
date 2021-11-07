package com.gatewayApi.gatewayApi;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
    
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/order/**")
                        .uri("lb://order-service"))

                .route(r -> r.path("/payment/**")
                        .uri("lb://payment-service"))
                .build();
    }
}
