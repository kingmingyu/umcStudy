package com.example.umc9thStudy.domain.member.controller;

import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;
import com.example.umc9thStudy.domain.review.dto.res.ReviewResponse;
import com.example.umc9thStudy.global.annotation.CheckPage;
import com.example.umc9thStudy.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestParam;

public interface MyPageControllerDocs {

    @Operation(
            summary = "내가 쓴 리뷰 목록 조회 API By 김민규 (개발 완료)",
            description = "내가 작성한 리뷰를 모두 조회합니다. 페이지네이션으로 제공"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<ReviewResponse.MyReviewListDTO> getMyReviews(
            @CheckPage @RequestParam Integer page,
            @RequestParam Long memberId
    );

    @Operation(
            summary = "현재 진행중/완료 한 미션 모아보기 API By 김민규 (개발 완료)",
            description = "유저가 현재 진행하고 있는/완료한 미션을 모두 조회합니다. 페이지네이션으로 제공"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<MissionResponse.MyMissionListDTO> getMyMission(
        @RequestParam(name = "status", defaultValue = "IN_PROGRESS") String status,
        @RequestParam Long memberId,
        @CheckPage @RequestParam(defaultValue = "1") Integer page
    );
}
