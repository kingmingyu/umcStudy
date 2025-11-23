package com.example.umc9thStudy.domain.mission.service.query;

import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;
import com.example.umc9thStudy.domain.mission.enums.Status;
import com.example.umc9thStudy.domain.mission.repository.MemberMissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MemberMissionService {
    private final MemberMissionRepository missionRepository;

    private static final int DEFAULT_PAGE_SIZE = 10;

    // 진행 중인 미션 조회
    public List<MissionResponse.MyMissionResponse> getInProgressMission(Long userId, Long lastMissionId){
        Pageable pageable = PageRequest.of(0, DEFAULT_PAGE_SIZE);

        return missionRepository.findMyMission(userId, Status.IN_PROGRESS, lastMissionId, pageable);
    }

    // 진행 완료한 미션 조회
    public List<MissionResponse.MyMissionResponse> getSuccessMission(Long userId, Long lastMissionId){
        Pageable pageable = PageRequest.of(0, DEFAULT_PAGE_SIZE);

        return missionRepository.findMyMission(userId, Status.SUCCESS, lastMissionId, pageable);
    }

}
