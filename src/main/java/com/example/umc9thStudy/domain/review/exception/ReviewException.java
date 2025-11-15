package com.example.umc9thStudy.domain.review.exception;

import com.example.umc9thStudy.global.apiPayload.code.BaseErrorCode;
import com.example.umc9thStudy.global.apiPayload.exception.GeneralException;

public class ReviewException extends GeneralException {
    public ReviewException(BaseErrorCode code) {
        super(code);
    }
}
