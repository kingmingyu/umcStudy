package com.example.umc9thStudy.domain.member.controller;

import com.example.umc9thStudy.domain.member.exception.code.MemberSuccessCode;
import com.example.umc9thStudy.domain.member.response.req.MemberReqDTO;
import com.example.umc9thStudy.domain.member.response.res.MemberResDTO;
import com.example.umc9thStudy.domain.member.service.MemberService;
import com.example.umc9thStudy.domain.member.service.command.MemberCommandService;
import com.example.umc9thStudy.domain.member.service.query.MemberQueryService;
import com.example.umc9thStudy.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    // 회원 가입
    @PostMapping("/sign-up")
    public ApiResponse<MemberResDTO.JoinDTO> signup(
            @RequestBody @Valid MemberReqDTO.JoinDTO dto
            ){
        return ApiResponse.onSuccess(MemberSuccessCode.MEMBER_FOUND, memberCommandService.signup(dto));
    }

    // 로그인
    @PostMapping("/login")
    public ApiResponse<MemberResDTO.LoginDTO> login(
            @RequestBody @Valid MemberReqDTO.LoginDTO dto
        ){
        return ApiResponse.onSuccess(MemberSuccessCode.MEMBER_FOUND, memberQueryService.login(dto));
    }
}
