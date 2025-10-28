package com.example.umc9thStudy.domain.mission.dto;

import lombok.Getter;

@Getter
public class HomeResponseDto {
    private Long missionId;
    private String restaurantName;
    private int rewardPoint;
    private Long minimumPrice;

    public HomeResponseDto(Long missionId, String restaurantName, int rewardPoint, Long minimumPrice) {
        this.missionId = missionId;
        this.restaurantName = restaurantName;
        this.rewardPoint = rewardPoint;
        this.minimumPrice = minimumPrice;
    }
}
