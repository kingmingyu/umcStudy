package com.example.umc9thStudy.domain.review.repository;

import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.restaurant.entity.Restaurant;
import com.example.umc9thStudy.domain.review.Service.query.ReviewQueryDsl;
import com.example.umc9thStudy.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewQueryDsl {
    List<Review> findAllByRestaurant(Restaurant restaurant);
    Page<Review> findAllByMember(Member member, Pageable pageRequest);

    Page<Review> findAllByRestaurant(Restaurant restaurant, Pageable pageRequest);
}
