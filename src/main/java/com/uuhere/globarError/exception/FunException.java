package com.uuhere.globarError.exception;

import org.springframework.http.HttpStatus;

public class FunException extends CasualException {
    public FunException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}