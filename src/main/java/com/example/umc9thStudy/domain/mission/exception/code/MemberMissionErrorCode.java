package com.example.umc9thStudy.domain.mission.exception.code;

import com.example.umc9thStudy.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberMissionErrorCode implements BaseErrorCode {

    EXIST_MISSION(HttpStatus.BAD_REQUEST, "MEMBERMISSION400_1", "이미 존재하는 id의 미션입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
