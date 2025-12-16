package com.example.umc9thStudy.domain.member.service.query;

import com.example.umc9thStudy.domain.member.response.req.MemberReqDTO;
import com.example.umc9thStudy.domain.member.response.res.MemberResDTO;
import jakarta.validation.Valid;

public interface MemberQueryService {

    // 로그인
    MemberResDTO.LoginDTO login(
            MemberReqDTO.@Valid LoginDTO dto
    );
}
