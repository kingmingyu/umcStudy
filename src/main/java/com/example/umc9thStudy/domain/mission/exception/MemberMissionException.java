package com.example.umc9thStudy.domain.mission.exception;

import com.example.umc9thStudy.global.apiPayload.code.BaseErrorCode;
import com.example.umc9thStudy.global.apiPayload.exception.GeneralException;

public class MemberMissionException extends GeneralException {
    public MemberMissionException(BaseErrorCode code) {
        super(code);
    }
}
