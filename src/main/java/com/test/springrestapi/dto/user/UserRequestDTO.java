package com.test.springrestapi.dto.user;

import jakarta.persistence.Column;
import lombok.Builder;

@Builder
public record UserRequestDTO(
        String username,
        String password,
        String confirmPassword,

        String fullName,

        String avatarUrl
) {
}
