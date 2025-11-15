package com.example.umc9thStudy.domain.review.entity;

import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.restaurant.entity.Restaurant;
import com.example.umc9thStudy.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Table(name = "review")
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "star_rate", nullable = false)
    private Float starRate;

    @Column(name = "content", nullable = false)
    private String content;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "reivew_photo_id")
    private ReviewPhoto reviewPhoto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") //
    private Member member; //

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "review_reply_id")
    private ReviewReply reviewReply;

}
