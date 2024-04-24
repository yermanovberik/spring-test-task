package com.test.springrestapi.dto.user;

import jakarta.persistence.Column;
import lombok.Builder;

@Builder
public record UserResponseDTO(
        String username,
        String fullName
) {
}
