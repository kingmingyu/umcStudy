package com.example.umc9thStudy.domain.mission.exception.code;

import com.example.umc9thStudy.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberMissionSuccessCode implements BaseSuccessCode {

    CREATE_MEMBER_MISSION(HttpStatus.CREATED, "MEMBERMISSION201_1", "사용자가 미션을 추가했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
