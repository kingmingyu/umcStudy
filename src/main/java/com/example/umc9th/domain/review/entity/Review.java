package com.example.umc9th.domain.review.entity;

import com.example.umc9th.domain.restaurant.entity.Region;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "star_rate", nullable = false)
    private Float starRate;

    @Column(name = "content", nullable = false)
    private String content;



    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "reivew_photo_id")
    private ReviewPhoto reviewPhoto;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "review_reply_id")
    private ReviewReply reviewReply;
}
