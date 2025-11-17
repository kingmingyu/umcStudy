package com.example.umc9thStudy.domain.mission.dto.res;

import com.example.umc9thStudy.domain.restaurant.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class MissionResponse {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MyMissionResponse {
        private String restaurantName;
        private Long minimumPrice;
        private int rewardPoint;
    }

    @Getter
    @Builder
    public static class HomeResponse{
        private Long missionId;
        private String restaurantName;
        private int rewardPoint;
        private Long minimumPrice;
    }

    @Builder
    public record MemberMissionResponse(
            int rewardPoint,
            Long minimumPrice,
            Restaurant restaurant
    ){}
}
