package com.example.umc9thStudy.domain.home.dto;

import com.example.umc9thStudy.domain.mission.dto.HomeResponseDto;
import com.example.umc9thStudy.domain.mission.dto.MyMissionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@AllArgsConstructor
public class HomeDataDto {
    private long userPoint;
    private long completedMissionCount;
    private Page<HomeResponseDto> availableMissionPage;
}
