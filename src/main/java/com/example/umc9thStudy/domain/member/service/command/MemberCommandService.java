package com.example.umc9thStudy.domain.member.service.command;

import com.example.umc9thStudy.domain.member.response.req.MemberReqDTO;
import com.example.umc9thStudy.domain.member.response.res.MemberResDTO;

public interface MemberCommandService {

    // 회원가입
    public MemberResDTO.JoinDTO signup(MemberReqDTO.JoinDTO dto);
}
