package com.test.springrestapi.exceptions;

import org.springframework.http.HttpStatus;

public class JwtTokenExpiredException extends ApiAuthenticationException {

    public JwtTokenExpiredException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }

}
