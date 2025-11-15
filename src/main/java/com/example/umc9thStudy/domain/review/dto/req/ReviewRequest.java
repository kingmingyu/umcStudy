package com.example.umc9thStudy.domain.review.dto.req;

import lombok.Builder;
import lombok.Getter;

public class ReviewRequest {
    @Getter
    @Builder
    public static class NewReviewRequest{
        float starRate;
        String content;
    }
}
