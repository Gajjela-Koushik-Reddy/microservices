package com.koushikreddy.accounts.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Customer does not exists")
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", message, fieldName, fieldValue));
    }
}
