package com.test.springrestapi.services.impl;

import com.test.springrestapi.dto.AuthenticationRequestDto;
import com.test.springrestapi.dto.AuthenticationResponseDto;
import com.test.springrestapi.dto.user.UserRequestDTO;
import com.test.springrestapi.enums.Role;
import com.test.springrestapi.exceptions.EntityAlreadyExistsException;
import com.test.springrestapi.jwt.JwtFactory;
import com.test.springrestapi.models.User;
import com.test.springrestapi.repositories.UserRepository;
import com.test.springrestapi.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtFactory jwtFactory;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponseDto register(UserRequestDTO userRequestDTO) {
        throwExceptionIfUserExists(userRequestDTO.username());
        User user = User.builder()
                .fullName(userRequestDTO.fullName())
                .username(userRequestDTO.username())
                .password(passwordEncoder.encode(userRequestDTO.password()))
                .avatarUrl(userRequestDTO.avatarUrl())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        String accessToken = jwtFactory.generateAccessToken(user);
        String refreshToken = jwtFactory.generateRefreshToken(user);
        AuthenticationResponseDto responseDto = AuthenticationResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
        return responseDto;
    }

    @Override
    public AuthenticationResponseDto login(AuthenticationRequestDto authenticationRequestDto) {
        log.info(authenticationRequestDto.password() + " "  + authenticationRequestDto.username());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequestDto.username(),
                        authenticationRequestDto.password()
                )
        );
        log.info(authenticationRequestDto.password() + " "  + authenticationRequestDto.username());

        User user = userRepository.findByUsername(authenticationRequestDto.username())
                .orElseThrow(() -> new EntityNotFoundException(
                        "User with username " + authenticationRequestDto.username() + " not found"
                ));

        String accessToken = jwtFactory.generateAccessToken(user);
        String refreshToken = jwtFactory.generateRefreshToken(user);

        return AuthenticationResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public void throwExceptionIfUserExists(String email) {
        userRepository.findByUsername(email)
                .ifPresent(foundUser -> {
                    throw new EntityAlreadyExistsException(
                            "User with the username " + foundUser.getUsername() + " already exists"
                    );
                });
    }
}
