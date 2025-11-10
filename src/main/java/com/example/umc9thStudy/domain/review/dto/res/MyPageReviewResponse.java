package com.example.umc9thStudy.domain.review.dto.res;

import com.example.umc9thStudy.domain.review.entity.Review;

public record MyPageReviewResponse(
        Long reviewId,
        String content,
        Float starRate,
        String restaurantName,
        String memberName
) {
    public static MyPageReviewResponse from(Review review){
        return new MyPageReviewResponse(
                review.getId(),
                review.getContent(),
                review.getStarRate(),
                review.getRestaurant().getName(),
                review.getMember().getName()
        );
    }
}
