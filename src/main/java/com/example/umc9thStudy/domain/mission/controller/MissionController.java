package com.example.umc9thStudy.domain.mission.controller;

import com.example.umc9thStudy.domain.mission.dto.req.MissionRequest;
import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;
import com.example.umc9thStudy.domain.mission.entity.Mission;
import com.example.umc9thStudy.domain.mission.exception.code.MemberMissionSuccessCode;
import com.example.umc9thStudy.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc9thStudy.domain.mission.service.command.MissionService;
import com.example.umc9thStudy.domain.mission.service.query.MissionQueryService;
import com.example.umc9thStudy.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MissionController implements MissionControllerDocs{

    private final MissionService missionService;
    private final MissionQueryService missionQueryService;

    // 유저 미션 추가
    @PostMapping("/api/user-missions")
    public ApiResponse<MissionResponse.MemberMissionResponse> addMemberMission(
            @RequestBody MissionRequest.CreateMemberMission request
            ){
        MissionResponse.MemberMissionResponse response = missionService.addMemberMission(request.memberId(), request.missionId());
        return ApiResponse.onSuccess(MemberMissionSuccessCode.CREATE_MEMBER_MISSION, response);
    }

    //특정 가게 미션 조회
    @GetMapping("api/missions/{restaurantId}")
    public ApiResponse<MissionResponse.RestaurantMissionListDTO> getRestaurantMissions(
            @RequestParam(defaultValue = "1") Integer page,
            @PathVariable Long restaurantId
    ){
        MissionSuccessCode code = MissionSuccessCode.MISSION_OK;
        return ApiResponse.onSuccess(code, missionQueryService.getRestaurantMissions(restaurantId, page));
    }
}
