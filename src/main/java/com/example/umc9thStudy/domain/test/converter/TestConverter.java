package com.example.umc9thStudy.domain.test.converter;

import com.example.umc9thStudy.domain.test.dto.res.TestResponseDTO;

public class TestConverter {

    //객체 -> DTO
    public static TestResponseDTO.Testing toTestingDto(
            String testing
    ){
        return TestResponseDTO.Testing.builder()
                .testing(testing)
                .build();
    }

    //객체 -> DTO
    public static TestResponseDTO.Exception toExceptionDTO(
            String testing
    ){
        return TestResponseDTO.Exception.builder()
                .testString(testing)
                .build();
    }
}
