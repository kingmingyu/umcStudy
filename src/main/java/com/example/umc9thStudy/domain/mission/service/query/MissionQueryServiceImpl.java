package com.example.umc9thStudy.domain.mission.service.query;

import com.example.umc9thStudy.domain.mission.converter.MissionConverter;
import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;
import com.example.umc9thStudy.domain.mission.entity.Mission;
import com.example.umc9thStudy.domain.mission.repository.MissionRepository;
import com.example.umc9thStudy.domain.restaurant.entity.Restaurant;
import com.example.umc9thStudy.domain.restaurant.exception.RestaurantException;
import com.example.umc9thStudy.domain.restaurant.exception.code.RestaurantErrorCode;
import com.example.umc9thStudy.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{

    private final RestaurantRepository restaurantRepository;
    private final MissionRepository missionRepository;

    @Override
    public MissionResponse.RestaurantMissionListDTO getRestaurantMissions(Long restaurantId, int page){

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() ->
                new RestaurantException(RestaurantErrorCode.RESTAURANT_NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Mission> result = missionRepository.findAllByRestaurant(restaurant, pageRequest);

        return MissionConverter.toRestaurantMissionListDTO(result);
    }

}
