package com.uuhere.globarError.exception;

import org.springframework.http.HttpStatus;

public class InvalidTokenIdException extends BusinessException {
    public InvalidTokenIdException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}