package com.example.umc9thStudy.domain.review.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewResponse {

    @Getter
    @Builder
    public static class NewReviewResponse{
        Long id;
        float starRate;
        String content;
        LocalDateTime created_at;
    }

    @Builder
    public record ReviewPreviewListDTO(
            List<ReviewPreviewDTO> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record ReviewPreviewDTO(
            String ownerNickname,
            float starRate,
            String content,
            LocalDateTime created_at
    ){}
}
