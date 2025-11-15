package com.example.umc9thStudy.domain.restaurant.exception;

import com.example.umc9thStudy.global.apiPayload.code.BaseErrorCode;
import com.example.umc9thStudy.global.apiPayload.exception.GeneralException;

public class RestaurantException extends GeneralException {
    public RestaurantException(BaseErrorCode code) {
        super(code);
    }
}
