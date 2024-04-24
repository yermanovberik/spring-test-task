package com.test.springrestapi.dto.request;

import lombok.Builder;

@Builder
public record RequestRequestDTO(
        String product,
        int quantity,
        String deliveryAddress,
        String phoneNumber) {
}