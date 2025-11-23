package com.example.umc9thStudy.domain.mission.converter;

import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;
import com.example.umc9thStudy.domain.mission.entity.MemberMission;
import com.example.umc9thStudy.domain.mission.entity.Mission;
import com.example.umc9thStudy.domain.mission.enums.Status;

public class MemberMissionConverter {

    //dto -> entity
    public static MemberMission toMemberMission(Member member, Mission mission){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(Status.IN_PROGRESS)
                .build();
    }

    //entity -> dto
    public static MissionResponse.MemberMissionResponse toMemberMissionResponse(MemberMission memberMission){
        return MissionResponse.MemberMissionResponse.builder()
                .rewardPoint(memberMission.getMission().getRewardPoint())
                .minimumPrice(memberMission.getMission().getMinimumPrice())
                .restaurant(memberMission.getMission().getRestaurant())
                .build();
    }
}
