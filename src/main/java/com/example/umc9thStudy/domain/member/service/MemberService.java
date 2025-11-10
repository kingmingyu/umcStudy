package com.example.umc9thStudy.domain.member.service;

import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.member.exception.code.MemberErrorCode;
import com.example.umc9thStudy.domain.member.repository.MemberRepository;
import com.example.umc9thStudy.global.apiPayload.exception.GeneralException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Member findMember(Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new GeneralException(MemberErrorCode.MEMBER_NOT_FOUND));
        return member;
    }
}
