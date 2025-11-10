package com.example.umc9thStudy.domain.home.service;

import com.example.umc9thStudy.domain.home.dto.HomeDataDto;
import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.member.exception.code.MemberErrorCode;
import com.example.umc9thStudy.domain.member.repository.MemberRepository;
import com.example.umc9thStudy.domain.mission.dto.res.HomeResponseDto;
import com.example.umc9thStudy.domain.mission.enums.Status;
import com.example.umc9thStudy.domain.mission.repository.MemberMissionRepository;
import com.example.umc9thStudy.domain.mission.repository.MissionRepository;
import com.example.umc9thStudy.global.apiPayload.exception.GeneralException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class HomeService {

    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

    public HomeDataDto getHomeScreenDate(Long userId, Long regionId, int page){

        //유저의 현재 포인트
        Member member = memberRepository.findById(userId).orElseThrow(() -> new GeneralException(MemberErrorCode.MEMBER_NOT_FOUND));

        //사용자 미션 성공 개수(홈 화면 상단)
        long completedMissionCount = memberMissionRepository.countByMemberIdAndStatus(
                userId,
                Status.SUCCESS
        );

        //지역에서 도전 가능한 미션
        Pageable availablePageable = PageRequest.of(page, 10);
        Page<HomeResponseDto> availableMissionPage = missionRepository.findAvailableMissionsByRegion(
                regionId,
                availablePageable
        );

        return new HomeDataDto(member.getPoint(), completedMissionCount, availableMissionPage);
    }
}
