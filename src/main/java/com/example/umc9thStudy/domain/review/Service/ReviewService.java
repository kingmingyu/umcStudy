package com.example.umc9thStudy.domain.review.Service;

import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.member.repository.MemberRepository;
import com.example.umc9thStudy.domain.restaurant.entity.Restaurant;
import com.example.umc9thStudy.domain.restaurant.repository.RestaurantRepository;
import com.example.umc9thStudy.domain.review.entity.Review;
import com.example.umc9thStudy.domain.review.entity.ReviewReply;
import com.example.umc9thStudy.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final MemberRepository memberRepository;


    public Review writeReview(Long memberId, Long restaurantId, String content, Float startRate){
        Member member = memberRepository.findById(memberId).orElseThrow(null);
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(null);

        Review newReview = Review.builder()
                .starRate(startRate)
                .content(content)
                .restaurant(restaurant)
                .build();

        return reviewRepository.save(newReview);
    }
}
