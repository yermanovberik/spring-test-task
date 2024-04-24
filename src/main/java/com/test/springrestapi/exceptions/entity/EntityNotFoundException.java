package com.test.springrestapi.exceptions.entity;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class EntityNotFoundException extends ResponseStatusException {
    public EntityNotFoundException(String message) {
        super(HttpStatus.CONFLICT,message);
    }
}
