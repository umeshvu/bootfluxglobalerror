package com.uuhere.globarError;

import com.uuhere.globarError.exception.CasualException;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TransactionErrorHandler {

    private final TransactionErrorService service;

    public TransactionErrorHandler(TransactionErrorService service) {
        this.service = service;
    }

    public Mono<ServerResponse> handleDeleteError(ServerRequest request) {
        return request.bodyToMono(DeleteRequest.class)
                .flatMap(service::validate)
                .flatMap(service::classify)
                .flatMap(service::callExternalService)
                .flatMap(service::delete)
                .flatMap(result -> ServerResponse.ok().bodyValue("Delete done"))
                  .onErrorResume(CasualException.class, ex -> {
                    return ServerResponse.badRequest().bodyValue(ex.getMessage()+" this is from CasualException");
                });
    }
}
