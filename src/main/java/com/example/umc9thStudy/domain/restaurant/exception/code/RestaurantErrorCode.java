package com.example.umc9thStudy.domain.restaurant.exception.code;

import com.example.umc9thStudy.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum RestaurantErrorCode implements BaseErrorCode {

    RESTAURANT_NOT_FOUND(HttpStatus.NOT_FOUND, "RESTAURANT404_1", "해당 ID의 음식점을 찾을 수 없습니다,");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
