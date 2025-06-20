package com.uuhere.globarError.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {
    private final HttpStatus status;

    public BusinessException(String message, HttpStatus status) {
        super(message+" this is business exception");
        this.status = status;
    }
}