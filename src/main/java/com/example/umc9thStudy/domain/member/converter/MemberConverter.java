package com.example.umc9thStudy.domain.member.converter;

import com.example.umc9thStudy.domain.member.enums.Role;
import com.example.umc9thStudy.domain.member.response.res.MyPageResponse;
import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.member.response.req.MemberReqDTO;
import com.example.umc9thStudy.domain.member.response.res.MemberResDTO;

public class MemberConverter {

    // 객체 -> DTO
    public static MyPageResponse.GetMyPageResponse toGetMyPageResponse(Member member){
        return MyPageResponse.GetMyPageResponse.builder()
                .name(member.getName())
                .email(member.getEmail())
                .points(member.getPoint())
                .build();
    }

    //Entity ->DTO
    public static MemberResDTO.JoinDTO toJoinDTO(Member member){
        return MemberResDTO.JoinDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    //DTO -> Entity
    public static Member toMember(MemberReqDTO.JoinDTO dto, String password, Role role){
        return Member.builder()
                .name(dto.name())
                .email(dto.email())
                .password(password)
                .role(role)
                .gender(dto.gender())
                .birth(dto.birth())
                .address(dto.address())
                .build();
    }

    public static MemberResDTO.LoginDTO toLoginDTO(Member member, String accessToken) {
        return MemberResDTO.LoginDTO.builder()
                .memberId(member.getId())
                .accessToken(accessToken)
                .build();
    }
}
