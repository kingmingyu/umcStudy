package com.example.umc9thStudy.domain.member.controller;

import com.example.umc9thStudy.domain.member.exception.code.MemberSuccessCode;
import com.example.umc9thStudy.domain.member.response.req.MemberReqDTO;
import com.example.umc9thStudy.domain.member.response.res.MemberResDTO;
import com.example.umc9thStudy.domain.member.service.MemberService;
import com.example.umc9thStudy.domain.member.service.command.MemberCommandService;
import com.example.umc9thStudy.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/sign-up")
    public ApiResponse<MemberResDTO.JoinDTO> signup(
            @RequestBody @Valid MemberReqDTO.JoinDTO dto
            ){
        return ApiResponse.onSuccess(MemberSuccessCode.MEMBER_FOUND, memberCommandService.signup(dto));
    }
}
