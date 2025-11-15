package com.example.umc9thStudy.domain.home.controller;

import com.example.umc9thStudy.domain.home.dto.HomeDataDto;
import com.example.umc9thStudy.domain.home.service.HomeService;
import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;
import com.example.umc9thStudy.global.apiPayload.ApiResponse;
import com.example.umc9thStudy.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/home")
    public ApiResponse<HomeDataDto> getHomePage(
        @RequestParam Long regionId,
        @RequestParam(name = "page", defaultValue = "0") int page
    ){
        Long memberId = 1L;

        HomeDataDto homeDataDto = homeService.getHomeScreenDate(memberId, regionId, page);

        return ApiResponse.onSuccess(GeneralSuccessCode.OK, homeDataDto);
    }
}
