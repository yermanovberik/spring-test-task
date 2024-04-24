package com.test.springrestapi.dto.news;

import lombok.Builder;

@Builder
public record NewsResponseDTO(
        String title,

        String body
) {
}
