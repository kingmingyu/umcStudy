package com.example.umc9thStudy.domain.review.converter;

import com.example.umc9thStudy.domain.review.dto.res.ReviewResponse;
import com.example.umc9thStudy.domain.review.entity.Review;

public class ReviewConverter {

    // 객체 -> dto
    public static ReviewResponse.NewReviewResponse toNewReviewResponse(Review review){
        return ReviewResponse.NewReviewResponse.builder()
                .id(review.getId())
                .content(review.getContent())
                .starRate(review.getStarRate())
                .created_at(review.getCreatedAt())
                .build();
    }
}
