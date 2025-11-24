package com.example.umc9thStudy.domain.mission.converter;

import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;
import com.example.umc9thStudy.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;

public class MissionConverter {
    //result -> dto
    public static MissionResponse.RestaurantMissionListDTO toRestaurantMissionListDTO(Page<Mission> result){
        return MissionResponse.RestaurantMissionListDTO.builder()
                .missionList(result.getContent().stream().map(
                        MissionConverter::toRestaurantMissionDTO).toList())
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }
    public static MissionResponse.RestaurantMissionDTO toRestaurantMissionDTO(Mission mission){
        return MissionResponse.RestaurantMissionDTO.builder()
                .minimumPrice(mission.getMinimumPrice())
                .reviewPoint(mission.getRewardPoint())
                .isActive(mission.getIsActive())
                .build();
    }

}
