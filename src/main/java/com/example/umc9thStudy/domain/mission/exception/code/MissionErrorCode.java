package com.example.umc9thStudy.domain.mission.exception.code;

import com.example.umc9thStudy.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionErrorCode implements BaseErrorCode {

    INVALID_MISSION_STATUS(HttpStatus.BAD_REQUEST, "MISSION400_1", "잘못된 미션 상태 요청입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
