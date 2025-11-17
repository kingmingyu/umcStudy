package com.example.umc9thStudy.domain.member.response.req;

import com.example.umc9thStudy.domain.member.enums.Gender;
import com.example.umc9thStudy.global.annotation.ExistFoods;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {

    public record JoinDTO(
            @NotBlank
            String name,
            @NotBlank
            String email,
            @NotNull
            Gender gender,
            @NotNull
            LocalDate birth,
            @NotNull
            String address,
            @ExistFoods
            List<Long> memberFood
    ){}
}
