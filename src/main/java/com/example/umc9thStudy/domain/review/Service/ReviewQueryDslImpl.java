package com.example.umc9thStudy.domain.review.Service;

import com.example.umc9thStudy.domain.review.entity.QReview;
import com.example.umc9thStudy.domain.review.entity.Review;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl{

    private final EntityManager em;

    @Override
    public List<Review> getReview(
            Predicate predicate
    ){

        //JPA 세팅
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        //Q 클래스 선언
        QReview review = QReview.review;

        return queryFactory
                .selectFrom(review)
                .where(predicate)
                .fetch();
    }
}
