package com.example.umc9thStudy.domain.review.converter;

import com.example.umc9thStudy.domain.review.dto.res.ReviewResponse;
import com.example.umc9thStudy.domain.review.entity.Review;
import org.springframework.data.domain.Page;

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

    //result -> dto
    public static ReviewResponse.ReviewPreviewListDTO toReviewPreviewListDTO(Page<Review> result){
        return ReviewResponse.ReviewPreviewListDTO.builder()
                .reviewList(result.getContent().stream()
                        .map(ReviewConverter::toReviewPreviewDTO).toList())
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }
    public static ReviewResponse.ReviewPreviewDTO toReviewPreviewDTO(Review review){
        return ReviewResponse.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .starRate(review.getStarRate())
                .content(review.getContent())
                .created_at(review.getCreatedAt())
                .build();
    }
}
