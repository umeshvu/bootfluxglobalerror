package com.uuhere.globarError.exception;

import org.springframework.http.HttpStatus;

public class ClassificationException extends BusinessException {
    public ClassificationException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}