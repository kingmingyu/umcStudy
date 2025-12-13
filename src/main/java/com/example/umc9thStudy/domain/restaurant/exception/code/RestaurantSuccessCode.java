package com.example.umc9thStudy.domain.restaurant.exception.code;

import com.example.umc9thStudy.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum RestaurantSuccessCode implements BaseSuccessCode {

    RESTAURANT_OK(HttpStatus.OK, "RESTAURANT200_1", "해당 id의 레스토랑을 찾았습니다."),
    RESTAURANT_CREATED(HttpStatus.CREATED, "RESTAURANT201_1", "레스토랑이 생성되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
