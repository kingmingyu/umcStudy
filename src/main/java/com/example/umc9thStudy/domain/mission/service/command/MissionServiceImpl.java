package com.example.umc9thStudy.domain.mission.service.command;

import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.member.exception.MemberException;
import com.example.umc9thStudy.domain.member.exception.code.MemberErrorCode;
import com.example.umc9thStudy.domain.member.repository.MemberRepository;
import com.example.umc9thStudy.domain.mission.converter.MemberMissionConverter;
import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;
import com.example.umc9thStudy.domain.mission.entity.MemberMission;
import com.example.umc9thStudy.domain.mission.entity.Mission;
import com.example.umc9thStudy.domain.mission.exception.MemberMissionException;
import com.example.umc9thStudy.domain.mission.exception.MissionException;
import com.example.umc9thStudy.domain.mission.exception.code.MemberMissionErrorCode;
import com.example.umc9thStudy.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9thStudy.domain.mission.repository.MemberMissionRepository;
import com.example.umc9thStudy.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService{

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public MissionResponse.MemberMissionResponse addMemberMission(Long memberId, Long missionId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId).orElseThrow(() -> new MissionException(MissionErrorCode.MISSION_NOT_FOUND));

        if(memberMissionRepository.existsByMemberAndId(member, mission)){
            throw new MemberMissionException(MemberMissionErrorCode.EXIST_MISSION);
        }

        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(member, mission);

        MemberMission savedMemberMission = memberMissionRepository.save(newMemberMission);

        return MemberMissionConverter.toMemberMissionResponse(savedMemberMission);
    }

}
