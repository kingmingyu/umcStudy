package com.example.umc9thStudy.domain.test.exception;

import com.example.umc9thStudy.global.apiPayload.code.BaseErrorCode;
import com.example.umc9thStudy.global.apiPayload.exception.GeneralException;

public class TestException extends GeneralException {
    public TestException(BaseErrorCode code) {
        super(code);
    }
}
