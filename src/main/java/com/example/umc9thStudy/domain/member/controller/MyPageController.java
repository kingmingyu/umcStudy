package com.example.umc9thStudy.domain.member.controller;

import com.example.umc9thStudy.domain.member.converter.MemberConverter;
import com.example.umc9thStudy.domain.member.response.res.MyPageResponse;
import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.member.service.MemberService;
import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;
import com.example.umc9thStudy.domain.mission.enums.Status;
import com.example.umc9thStudy.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9thStudy.domain.mission.service.query.MemberMissionService;
import com.example.umc9thStudy.domain.review.Service.ReviewQueryService;
import com.example.umc9thStudy.domain.review.dto.res.MyPageReviewResponse;
import com.example.umc9thStudy.global.apiPayload.ApiResponse;
import com.example.umc9thStudy.global.apiPayload.code.GeneralSuccessCode;
import com.example.umc9thStudy.global.apiPayload.exception.GeneralException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class MyPageController {

    private final ReviewQueryService reviewQueryService;
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

    //내가 작성한 리뷰 모아보기
    @GetMapping("/mypage/reivews")
    public ApiResponse<List<MyPageReviewResponse>> getMypageReviews(
            @RequestParam String query,
            @RequestParam String type
    ){
        List<MyPageReviewResponse> result = reviewQueryService.getReview(query, type);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, result);
    }

    //현재 진행중, 진행 완료한 미션 모아보기
    @GetMapping("/mypage/missions")
    public ApiResponse<List<MissionResponse.MyMissionResponse>> getMyMission(
        @RequestParam(name = "status") String status,
        @RequestParam(name = "lastMissionId", required = false) Long lastMissionId
    ){
        Long memberId = 1L;

        Status missionStatus;
        try{
            missionStatus = Status.valueOf(status);
        }
        catch (IllegalArgumentException e){
            throw new GeneralException(MissionErrorCode.INVALID_MISSION_STATUS);
        }
        List<MissionResponse.MyMissionResponse> missionResponseList;

        // 진행 중인 미션 리스트 불러오기
        if(missionStatus == Status.IN_PROGRESS){
            missionResponseList = memberMissionService.getInProgressMission(memberId, lastMissionId);
        }
        // 성공한 미션 리스트 불러오기
        else if(missionStatus == Status.SUCCESS){
            missionResponseList = memberMissionService.getSuccessMission(memberId, lastMissionId);
        }
        //잘못된 상태 요청 시 예외 처리
        else{
            throw new GeneralException(MissionErrorCode.INVALID_MISSION_STATUS);
        }

        return ApiResponse.onSuccess(GeneralSuccessCode.OK, missionResponseList);
    }
}
