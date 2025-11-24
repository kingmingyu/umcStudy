package com.example.umc9thStudy.domain.review.controller;

import com.example.umc9thStudy.domain.review.dto.res.ReviewResponse;
import com.example.umc9thStudy.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewControllerDocs {

    @Operation(
            summary = "가게의 리뷰 목록 조회 API",
            description = "특정 가게의 리뷰를 모두 조회합니다. 페이지네이션으로 제공"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<ReviewResponse.ReviewPreviewListDTO> getReviews(
            @RequestParam String restaurantName,
            @RequestParam Integer page
    );
}
