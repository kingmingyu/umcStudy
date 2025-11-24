package com.example.umc9thStudy.domain.member.controller;

import com.example.umc9thStudy.domain.member.converter.MemberConverter;
import com.example.umc9thStudy.domain.member.response.res.MyPageResponse;
import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.member.service.MemberService;
import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;
import com.example.umc9thStudy.domain.mission.service.query.MemberMissionService;
import com.example.umc9thStudy.domain.review.Service.query.ReviewQueryServiceImpl;
import com.example.umc9thStudy.domain.review.dto.res.MyPageReviewResponse;
import com.example.umc9thStudy.domain.review.dto.res.ReviewResponse;
import com.example.umc9thStudy.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9thStudy.global.annotation.CheckPage;
import com.example.umc9thStudy.global.apiPayload.ApiResponse;
import com.example.umc9thStudy.global.apiPayload.code.GeneralSuccessCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class MyPageController implements MyPageControllerDocs{

    private final ReviewQueryServiceImpl reviewQueryService;
    private final MemberService memberService;
    private final MemberMissionService memberMissionService;

    // 마이 페이지 화면
    @GetMapping("/mypage/{memberId}")
    public ApiResponse<MyPageResponse.GetMyPageResponse> getMypage(
            @PathVariable Long memberId
    ){
        Member member = memberService.findMember(memberId);

        MyPageResponse.GetMyPageResponse response = MemberConverter.toGetMyPageResponse(member);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, response);
    }

    //내가 작성한 리뷰 모아보기(별점순, 가게별)
    @GetMapping("/mypage/reviews/search")
    public ApiResponse<List<MyPageReviewResponse>> getMypageReviews(
            @RequestParam String query,
            @RequestParam String type
    ){
        List<MyPageReviewResponse> result = reviewQueryService.getReview(query, type);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, result);
    }

    // 내가 쓴 리뷰 목록 보기
    @GetMapping("/mypage/reviews")
    public ApiResponse<ReviewResponse.MyReviewListDTO> getMyReviews(
            @CheckPage @RequestParam(defaultValue = "1") Integer page,
            @RequestParam Long memberId
    ){
        int adjustedPage = page - 1;
        ReviewSuccessCode code = ReviewSuccessCode.REVIEW_OK;
        return ApiResponse.onSuccess(code, reviewQueryService.findMyReviews(memberId, adjustedPage));
    }

    //현재 진행중, 진행 완료한 미션 모아보기
    @GetMapping("/mypage/missions")
    public ApiResponse<MissionResponse.MyMissionListDTO> getMyMission(
        @RequestParam(name = "status", defaultValue = "IN_PROGRESS") String status,
        @RequestParam Long memberId,
        @CheckPage @RequestParam(defaultValue = "1") Integer page
    ){
        int adjustedPage = page - 1;

        return ApiResponse.onSuccess(GeneralSuccessCode.OK, memberMissionService.findMyMission(memberId, status, adjustedPage));
    }
}
