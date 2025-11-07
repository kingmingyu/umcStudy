package com.example.umc9thStudy.domain.review.controller;

import com.example.umc9thStudy.domain.review.Service.ReviewQueryService;
import com.example.umc9thStudy.domain.review.dto.MyPageReviewResponse;
import com.example.umc9thStudy.global.apiPayload.ApiResponse;
import com.example.umc9thStudy.global.apiPayload.code.GeneralSuccessCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class MyPageController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/mypage/reivews")
    public ApiResponse<List<MyPageReviewResponse>> getMypageReviews(
            @RequestParam String query,
            @RequestParam String type
    ){
        List<MyPageReviewResponse> result = reviewQueryService.getReview(query, type);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, result);
    }
}
