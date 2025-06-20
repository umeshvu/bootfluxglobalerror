package com.uuhere.globarError;

import com.uuhere.globarError.exception.ClassificationException;
import com.uuhere.globarError.exception.FunException;
import com.uuhere.globarError.exception.InvalidWalletIdException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TransactionErrorService {
    public Mono<DeleteRequest> validate(DeleteRequest req) {

        if (req.getErrorId() == null || req.getErrorId().isBlank()) {
            return Mono.error(new FunException("Fun exception"));
        }
        return Mono.just(req);
    }

    public Mono<DeleteRequest> classify(DeleteRequest req) {
        boolean condition = req.getErrorId().startsWith("TX"); // dummy logic
        if (!condition) {
            return Mono.error(new ClassificationException("Classification failed"));
        }
        return Mono.just(req);
    }

    public Mono<DeleteRequest> callExternalService(DeleteRequest req) {
        // Simulate an HTTP call
        return WebClient.create()
                .get()
                .uri("http://external-service/check/" + req.getErrorId())
                .retrieve()
                .bodyToMono(Boolean.class)
                .flatMap(allowed -> {
                    if (Boolean.TRUE.equals(allowed)) {
                        return Mono.just(req);
                    } else {
                        return Mono.error(new InvalidWalletIdException("External service denied delete"));
                    }
                });
    }

    public Mono<Void> delete(DeleteRequest req) {
        // Replace with actual DB call
        return Mono.fromRunnable(() -> {
            System.out.println("Deleting from DB: " + req.getErrorId());
        }).then();
    }
}
