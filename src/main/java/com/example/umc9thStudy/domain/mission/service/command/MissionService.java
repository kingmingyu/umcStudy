package com.example.umc9thStudy.domain.mission.service.command;

import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;

public interface MissionService {
    // 사용자가 가게의 미션 도전하기
    MissionResponse.MemberMissionResponse addMemberMission(Long memberId, Long missionId);
}
