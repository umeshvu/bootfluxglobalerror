package com.uuhere.globarError;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ErrorRouter {
    @Bean
    public RouterFunction<ServerResponse> route(TransactionErrorHandler handler) {
        return RouterFunctions
                .route(RequestPredicates.POST("/delete-error").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::handleDeleteError);
    }
}
