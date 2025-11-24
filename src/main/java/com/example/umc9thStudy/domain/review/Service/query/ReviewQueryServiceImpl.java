package com.example.umc9thStudy.domain.review.Service.query;

import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.member.exception.MemberException;
import com.example.umc9thStudy.domain.member.exception.code.MemberErrorCode;
import com.example.umc9thStudy.domain.member.repository.MemberRepository;
import com.example.umc9thStudy.domain.restaurant.entity.Restaurant;
import com.example.umc9thStudy.domain.restaurant.exception.RestaurantException;
import com.example.umc9thStudy.domain.restaurant.exception.code.RestaurantErrorCode;
import com.example.umc9thStudy.domain.restaurant.repository.RestaurantRepository;
import com.example.umc9thStudy.domain.review.converter.ReviewConverter;
import com.example.umc9thStudy.domain.review.dto.res.MyPageReviewResponse;
import com.example.umc9thStudy.domain.review.dto.res.ReviewResponse;
import com.example.umc9thStudy.domain.review.entity.QReview;
import com.example.umc9thStudy.domain.review.entity.Review;
import com.example.umc9thStudy.domain.review.repository.ReviewRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewQueryServiceImpl implements ReviewQueryService{

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final MemberRepository memberRepository;

    public List<MyPageReviewResponse> getReview(String query, String type) {

        //Q 클래스 정의
        QReview review = QReview.review;

        //BooleanBuilder 정의
        BooleanBuilder builder = new BooleanBuilder();

        //BooleanBuilder 사용

        // 동적 쿼리: 검색 조건(가게별 or 별점별)
        if(type.equals("restaurant")){
            builder.and(review.restaurant.name.contains(query));
        }
        if (type.equals("star")) {
            float starRating = Float.parseFloat(query);
            //별점이 5점인 경우
            if (starRating == 5.0f) {
                builder.and(review.starRate.eq(5.0f));
            }
            //별점이 4점대, 3점대인 경우
            else if (starRating < 5.0f) {
                float startRange = starRating;
                float endRange = starRating + 1.0f;

                // startRange.0 이상(goe)이고 endRange.0 미만(lt)
                builder.and(review.starRate.goe(startRange));
                builder.and(review.starRate.lt(endRange));
            }
        }

        //repository 사용 & 결과 매핑
        List<Review> reviewList = reviewRepository.getReview(builder);

        List<MyPageReviewResponse> dtoList = reviewList.stream()
                .map(MyPageReviewResponse::from)
                .collect(Collectors.toList());

        //return
        return dtoList;
    }

    @Override
    public ReviewResponse.ReviewPreviewListDTO findReview(String restaurantName, Integer page) {

        Restaurant restaurant = restaurantRepository.findByName(restaurantName).orElseThrow(()
                -> new RestaurantException(RestaurantErrorCode.RESTAURANT_NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<Review> result = reviewRepository.findAllByRestaurant(restaurant, pageRequest);

        return ReviewConverter.toReviewPreviewListDTO(result);
    }

    @Override
    public ReviewResponse.MyReviewListDTO findMyReviews(Long memberId, Integer page){
        Member member = memberRepository.findById(memberId).orElseThrow(() ->
                new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Review> result = reviewRepository.findAllByMember(member, pageRequest);

        return ReviewConverter.toMyReviewListDTO(result);
    }
}
