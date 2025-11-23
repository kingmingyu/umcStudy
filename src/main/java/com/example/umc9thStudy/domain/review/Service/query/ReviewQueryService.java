package com.example.umc9thStudy.domain.review.Service.query;

import com.example.umc9thStudy.domain.review.dto.res.MyPageReviewResponse;
import com.example.umc9thStudy.domain.review.dto.res.ReviewResponse;

import java.util.List;

public interface ReviewQueryService {
    // 마이페이지에서 내가 쓴 리뷰 보기
    List<MyPageReviewResponse> getReview(String query, String type);

    //가게에서 리뷰 리스트 보기
    ReviewResponse.ReviewPreviewListDTO findReview(String restaurantName, Integer page);
}
