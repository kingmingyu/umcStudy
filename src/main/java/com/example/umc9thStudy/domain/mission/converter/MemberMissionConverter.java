package com.example.umc9thStudy.domain.mission.converter;

import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;
import com.example.umc9thStudy.domain.mission.entity.MemberMission;
import com.example.umc9thStudy.domain.mission.entity.Mission;
import com.example.umc9thStudy.domain.mission.enums.Status;
import org.springframework.data.domain.Page;

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

    //result -> dto
    public static MissionResponse.MyMissionListDTO toMyMissionListDTO(Page<MemberMission> result) {
        return MissionResponse.MyMissionListDTO.builder()
                .myMissionList(result.getContent().stream()
                        .map(MemberMissionConverter::toMyMissionResponse).toList())
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }
    public static MissionResponse.MyMissionResponse toMyMissionResponse(MemberMission memberMission){
        return MissionResponse.MyMissionResponse.builder()
                .restaurantName(memberMission.getMission().getRestaurant().getName())
                .minimumPrice(memberMission.getMission().getMinimumPrice())
                .rewardPoint(memberMission.getMission().getRewardPoint())
                .build();
    }
}
