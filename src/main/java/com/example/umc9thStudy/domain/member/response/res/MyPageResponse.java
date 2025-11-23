package com.example.umc9thStudy.domain.member.response.res;

import lombok.Builder;
import lombok.Getter;

public class MyPageResponse {
    @Getter
    @Builder
    public static class GetMyPageResponse{
        private String name;
        private String email;
        private Long points;
    }
}
