package com.test.springrestapi.controllers;

import com.test.springrestapi.dto.AuthenticationRequestDto;
import com.test.springrestapi.dto.AuthenticationResponseDto;
import com.test.springrestapi.dto.user.UserRequestDTO;
import com.test.springrestapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponseDto register(
            @RequestBody UserRequestDTO requestDTO
    ) {
        return userService.register(requestDTO);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponseDto login(
            @RequestBody AuthenticationRequestDto request
    ) {
        return userService.login(request);
    }
}

