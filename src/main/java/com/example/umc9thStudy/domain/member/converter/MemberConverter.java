package com.example.umc9thStudy.domain.member.converter;

import com.example.umc9thStudy.domain.member.dto.res.MyPageResponse;
import com.example.umc9thStudy.domain.member.entity.Member;

public class MemberConverter {

    // 객체 -> DTO
    public static MyPageResponse.GetMyPageResponse toGetMyPageResponse(Member member){
        return MyPageResponse.GetMyPageResponse.builder()
                .name(member.getName())
                .email(member.getEmail())
                .points(member.getPoint())
                .build();
    }
}
