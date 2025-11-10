package com.example.umc9thStudy.domain.member.exception;

import com.example.umc9thStudy.global.apiPayload.code.BaseErrorCode;
import com.example.umc9thStudy.global.apiPayload.exception.GeneralException;

public class MemberException extends GeneralException {
    public MemberException(BaseErrorCode code) {
        super(code);
    }
}
