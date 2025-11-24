package com.example.umc9thStudy.domain.mission.controller;

import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;
import com.example.umc9thStudy.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface MissionControllerDocs {
    @Operation(
            summary = "가게의 미션목록을 보여줍니다. by 김민규 (개발 완료)",
            description = "특정 가게의 미션 리스트를 보여줍니다.(페이지네이션)"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<MissionResponse.RestaurantMissionListDTO> getRestaurantMissions(
            @RequestParam(defaultValue = "1") Integer page,
            @PathVariable Long restaurantId
    );

}
