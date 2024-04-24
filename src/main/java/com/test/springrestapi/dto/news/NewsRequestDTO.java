package com.test.springrestapi.dto.news;

import jakarta.persistence.Column;
import lombok.Builder;

@Builder
public record NewsRequestDTO(
        String title,

        String body
) {
}
