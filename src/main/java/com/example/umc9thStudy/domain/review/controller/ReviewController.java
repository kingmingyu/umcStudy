package com.example.umc9thStudy.domain.review.controller;

import com.example.umc9thStudy.domain.review.Service.command.ReviewCommandService;
import com.example.umc9thStudy.domain.review.Service.query.ReviewQueryService;
import com.example.umc9thStudy.domain.review.converter.ReviewConverter;
import com.example.umc9thStudy.domain.review.dto.req.ReviewRequest;
import com.example.umc9thStudy.domain.review.dto.res.ReviewResponse;
import com.example.umc9thStudy.domain.review.entity.Review;
import com.example.umc9thStudy.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9thStudy.global.annotation.CheckPage;
import com.example.umc9thStudy.global.apiPayload.ApiResponse;
import com.example.umc9thStudy.global.apiPayload.code.GeneralSuccessCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewController implements ReviewControllerDocs{

    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    // 리뷰 생성
    @PostMapping("/restaurant/{restaurantId}/reviews")
    public ApiResponse<ReviewResponse.NewReviewResponse> writeReview(
            @RequestBody ReviewRequest.NewReviewRequest request,
            @PathVariable Long restaurantId
    ){
        Long tempMemberId = 1L;
        Review review = reviewCommandService.writeReview(tempMemberId, restaurantId, request.getContent(), request.getStarRate());

        ReviewResponse.NewReviewResponse response = ReviewConverter.toNewReviewResponse(review);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, response);
    }

    // 가게의 리뷰 목록 조회
    @GetMapping("/reviews")
    public ApiResponse<ReviewResponse.ReviewPreviewListDTO> getReviews(
            @RequestParam String restaurantName,
            @CheckPage @RequestParam(defaultValue = "1") Integer page
    ){
        int adjustedPage = page - 1;
        ReviewSuccessCode code = ReviewSuccessCode.REVIEW_OK;
        return ApiResponse.onSuccess(code, reviewQueryService.findReview(restaurantName, adjustedPage));
    }
}
