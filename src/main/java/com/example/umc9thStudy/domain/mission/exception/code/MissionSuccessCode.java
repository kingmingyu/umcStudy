package com.example.umc9thStudy.domain.mission.exception.code;

import com.example.umc9thStudy.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum MissionSuccessCode implements BaseSuccessCode {

    MISSION_OK(HttpStatus.OK, "MISSION200_1", "미션이 성공적으로 반환되었습니다."),
    MISSION_CREATED(HttpStatus.CREATED, "MISSION201_1", "미션이 생성되었습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
