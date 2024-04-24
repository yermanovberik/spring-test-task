package com.test.springrestapi.dto;


public record AuthenticationRequestDto(

        String username,

        String password

) { }
