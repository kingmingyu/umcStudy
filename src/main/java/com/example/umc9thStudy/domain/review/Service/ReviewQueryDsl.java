package com.example.umc9thStudy.domain.review.Service;

import com.example.umc9thStudy.domain.review.entity.Review;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface ReviewQueryDsl {

    // 리뷰 받기 API
    List<Review> getReview(
            Predicate predicate
    );
}
