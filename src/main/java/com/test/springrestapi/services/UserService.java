package com.test.springrestapi.services;

import com.test.springrestapi.dto.AuthenticationRequestDto;
import com.test.springrestapi.dto.AuthenticationResponseDto;
import com.test.springrestapi.dto.user.UserRequestDTO;

public interface UserService {
    AuthenticationResponseDto register(UserRequestDTO userRequestDTO);
    AuthenticationResponseDto login(AuthenticationRequestDto authenticationRequestDto);

    void throwExceptionIfUserExists(String username);
}
