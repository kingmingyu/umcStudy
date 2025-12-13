package com.example.umc9thStudy.domain.mission.service.query;

import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;

public interface MissionQueryService {
    MissionResponse.RestaurantMissionListDTO getRestaurantMissions(Long restaurantId, int page);
}
