package com.test.springrestapi.dto.request;

import lombok.Builder;

@Builder
public record RequestResponseDTO(
        String product,
        int quantity,
        String deliveryAddress,
        String phoneNumber) {
}