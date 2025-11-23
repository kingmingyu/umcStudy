package com.example.umc9thStudy.domain.member.exception.code;

import com.example.umc9thStudy.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberSuccessCode implements BaseSuccessCode {

    MEMBER_FOUND(HttpStatus.OK, "MEMBER200_1", "사용자를 성공적으로 조회했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
