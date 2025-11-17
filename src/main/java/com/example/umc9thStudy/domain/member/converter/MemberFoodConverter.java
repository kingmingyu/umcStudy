package com.example.umc9thStudy.domain.member.converter;

import com.example.umc9thStudy.domain.member.entity.Food;
import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.member.entity.MemberFood;
import com.example.umc9thStudy.domain.member.response.req.MemberReqDTO;

public class MemberFoodConverter {

    // dto -> entity
    public static MemberFood toMemberFood(Member member, Food food){
        return MemberFood.builder()
                .member(member)
                .food(food)
                .build();
    }
}
