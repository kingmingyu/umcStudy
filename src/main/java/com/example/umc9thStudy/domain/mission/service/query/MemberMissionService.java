package com.example.umc9thStudy.domain.mission.service.query;

import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.member.exception.MemberException;
import com.example.umc9thStudy.domain.member.exception.code.MemberErrorCode;
import com.example.umc9thStudy.domain.member.repository.MemberRepository;
import com.example.umc9thStudy.domain.mission.converter.MemberMissionConverter;
import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;
import com.example.umc9thStudy.domain.mission.entity.MemberMission;
import com.example.umc9thStudy.domain.mission.enums.Status;
import com.example.umc9thStudy.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9thStudy.domain.mission.repository.MemberMissionRepository;
import com.example.umc9thStudy.global.apiPayload.exception.GeneralException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class MemberMissionService {

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    private static final int DEFAULT_PAGE_SIZE = 10;

    // 진행 중인 미션 조회
    public MissionResponse.MyMissionListDTO findMyMission(Long memberId, String statusStr, Integer page){

        Status status;
        try {
            status = Status.valueOf(statusStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new GeneralException(MissionErrorCode.INVALID_MISSION_STATUS);
        }

        Member member = memberRepository.findById(memberId).orElseThrow(() ->
                new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page, DEFAULT_PAGE_SIZE);
        Page<MemberMission> result = memberMissionRepository.findAllByMemberAndStatus(member, status, pageRequest);

        return MemberMissionConverter.toMyMissionListDTO(result);
    }
}
