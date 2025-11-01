package com.example.umc9thStudy.domain.review.repository;

import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.restaurant.entity.Restaurant;
import com.example.umc9thStudy.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByRestaurant(Restaurant restaurant);
    List<Review> findAllByMember(Member member);
}
