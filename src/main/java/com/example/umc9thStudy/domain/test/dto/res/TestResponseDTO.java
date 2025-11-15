package com.example.umc9thStudy.domain.test.dto.res;

import lombok.Builder;
import lombok.Getter;

public class TestResponseDTO {

    @Getter
    @Builder
    public static class Testing{
        private String testing;
    }

    @Getter
    @Builder
    public static class Exception{
        private String testString;
    }
}
