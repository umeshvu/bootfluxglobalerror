package com.uuhere.globarError.exception;

import org.springframework.http.HttpStatus;

public class InvalidWalletIdException extends BusinessException {
    public InvalidWalletIdException(String message) {
        super(message, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}