package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.domain.restaurant.entity.Restaurant;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "mission")
@Builder
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reward_point", nullable = false)
    private int rewardPoint;

    @Column(name = "minimum_price", nullable = false)
    private Long minimumPrice;

    @Column(name = "is_active")
    @Builder.Default
    private int isActive = 0;

}
