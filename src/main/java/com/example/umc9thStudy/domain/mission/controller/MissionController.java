package com.example.umc9thStudy.domain.mission.controller;

import com.example.umc9thStudy.domain.mission.dto.req.MissionRequest;
import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;
import com.example.umc9thStudy.domain.mission.exception.code.MemberMissionSuccessCode;
import com.example.umc9thStudy.domain.mission.service.command.MissionService;
import com.example.umc9thStudy.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/api/user-missions")
    public ApiResponse<MissionResponse.MemberMissionResponse> addMemberMission(
            @RequestBody MissionRequest.CreateMemberMission request
            ){
        MissionResponse.MemberMissionResponse response = missionService.addMemberMission(request.memberId(), request.missionId());
        return ApiResponse.onSuccess(MemberMissionSuccessCode.CREATE_MEMBER_MISSION, response);
    }
}
