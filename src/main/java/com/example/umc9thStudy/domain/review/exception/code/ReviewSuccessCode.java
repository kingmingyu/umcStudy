package com.example.umc9thStudy.domain.review.exception.code;

import com.example.umc9thStudy.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ReviewSuccessCode implements BaseSuccessCode {

    REVIEW_OK(HttpStatus.OK, "REVIEW200_1", "리뷰 응답 성공"),
    REVIEW_CREATED(HttpStatus.CREATED, "REVIEW201_1", "리뷰 생성 성공"), ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
