package ru.stuff.apigateway.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.stuff.apigateway.filter.AuthenticationFilter;

@Configuration
public class RouteConfig {

    @Autowired
    AuthenticationFilter filter;

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        "user-service",
                        p -> p
                                .path("/profile/**")
                                .filters(f -> f.filter(filter))
                                .uri("lb://user-service"))
                .route(
                        "auth-service",
                        p -> p
                                .path("/auth/**")
                                .filters(f -> f.filter(filter))
                                .uri("lb://auth-service"))
                .route(
                        "recipe-service",
                        p -> p
                                .path("/recipe/**")
                                .filters(f -> f.filter(filter))
                                .uri("lb://recipe-service"))
                .build();
    }
}
