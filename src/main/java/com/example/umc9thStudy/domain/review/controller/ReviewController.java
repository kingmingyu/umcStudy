package com.example.umc9thStudy.domain.review.controller;

import com.example.umc9thStudy.domain.review.Service.ReviewService;
import com.example.umc9thStudy.domain.review.converter.ReviewConverter;
import com.example.umc9thStudy.domain.review.dto.req.ReviewRequest;
import com.example.umc9thStudy.domain.review.dto.res.ReviewResponse;
import com.example.umc9thStudy.domain.review.entity.Review;
import com.example.umc9thStudy.global.apiPayload.ApiResponse;
import com.example.umc9thStudy.global.apiPayload.code.GeneralSuccessCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/restaurant/{restaurantId}/reviews")
    public ApiResponse<ReviewResponse.NewReviewResponse> writeReview(
            @RequestBody ReviewRequest.NewReviewRequest request,
            @PathVariable Long restaurantId
    ){
        Long tempMemberId = 1L;
        Review review = reviewService.writeReview(tempMemberId, restaurantId, request.getContent(), request.getStarRate());

        ReviewResponse.NewReviewResponse response = ReviewConverter.toNewReviewResponse(review);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, response);
    }
}
