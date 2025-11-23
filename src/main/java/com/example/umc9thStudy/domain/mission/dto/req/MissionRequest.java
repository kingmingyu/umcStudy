package com.example.umc9thStudy.domain.mission.dto.req;

public class MissionRequest {
    public record CreateMemberMission(
            Long missionId,
            Long memberId
    ) {}
}
