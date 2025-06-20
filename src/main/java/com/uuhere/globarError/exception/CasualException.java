package com.uuhere.globarError.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CasualException extends RuntimeException {
    private final HttpStatus status;

    public CasualException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}