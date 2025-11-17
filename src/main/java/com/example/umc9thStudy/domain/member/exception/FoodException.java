package com.example.umc9thStudy.domain.member.exception;

import com.example.umc9thStudy.global.apiPayload.code.BaseErrorCode;
import com.example.umc9thStudy.global.apiPayload.exception.GeneralException;

public class FoodException extends GeneralException {
    public FoodException(BaseErrorCode code) {
        super(code);
    }
}
