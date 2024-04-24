package com.test.springrestapi.exceptions;

import com.test.springrestapi.dto.ApiExceptionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
@RequiredArgsConstructor
public class ApiExceptionResponseFactory {


    private final ZoneId zoneId;

    public ApiExceptionResponseDto createApiExceptionResponseDto(HttpStatus httpStatus, String errorMessage) {
        return ApiExceptionResponseDto.builder()
                .errorCode(httpStatus.value())
                .httpStatus(httpStatus)
                .timestamp(ZonedDateTime.now(zoneId))
                .errorMessage(errorMessage)
                .build();
    }
}
