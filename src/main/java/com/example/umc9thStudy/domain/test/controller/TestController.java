package com.example.umc9thStudy.domain.test.controller;

import com.example.umc9thStudy.domain.test.converter.TestConverter;
import com.example.umc9thStudy.domain.test.dto.res.TestResponseDTO;
import com.example.umc9thStudy.domain.test.exception.TestException;
import com.example.umc9thStudy.domain.test.service.query.TestQueryService;
import com.example.umc9thStudy.global.apiPayload.ApiResponse;
import com.example.umc9thStudy.global.apiPayload.code.GeneralErrorCode;
import com.example.umc9thStudy.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/temp")
public class TestController {

    private final TestQueryService testQueryService;

    @GetMapping("/test")
    public ApiResponse<TestResponseDTO.Testing> test() throws Exception{
        //응답 코드 정의
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        throw new TestException(GeneralErrorCode.INTERNAL_SERVER_ERROR_500);
//        return ApiResponse.onSuccess(
//                code,
//                TestConverter.toTestingDto("This is test")
//        );
    }

    @GetMapping("/exception")
    public ApiResponse<TestResponseDTO.Exception> exception(
            @RequestParam Long flag
    ){
        testQueryService.checkFlag(flag);

        //응답 코드 정의
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, TestConverter.toExceptionDTO("This is Test!"));
    }
}
