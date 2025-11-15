package com.example.umc9thStudy.domain.review.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class ReviewResponse {

    @Getter
    @Builder
    public static class NewReviewResponse{
        Long id;
        float starRate;
        String content;
        LocalDateTime created_at;
    }
}
