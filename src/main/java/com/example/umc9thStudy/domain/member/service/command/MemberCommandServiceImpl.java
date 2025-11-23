package com.example.umc9thStudy.domain.member.service.command;

import com.example.umc9thStudy.domain.member.converter.MemberConverter;
import com.example.umc9thStudy.domain.member.converter.MemberFoodConverter;
import com.example.umc9thStudy.domain.member.entity.Food;
import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.member.entity.MemberFood;
import com.example.umc9thStudy.domain.member.exception.FoodException;
import com.example.umc9thStudy.domain.member.exception.code.FoodErrorCode;
import com.example.umc9thStudy.domain.member.repository.FoodRepository;
import com.example.umc9thStudy.domain.member.repository.MemberFoodRepository;
import com.example.umc9thStudy.domain.member.repository.MemberRepository;
import com.example.umc9thStudy.domain.member.response.req.MemberReqDTO;
import com.example.umc9thStudy.domain.member.response.res.MemberResDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final MemberFoodRepository memberFoodRepository;
    private final FoodRepository foodRepository;

    // 회원 가입
    @Override
    @Transactional
    public MemberResDTO.JoinDTO signup(
            MemberReqDTO.JoinDTO dto
    ){
        // 사용자 생성
        Member member = MemberConverter.toMember(dto);

        // 사용자 저장
        memberRepository.save(member);

        // 선호 음식 존재 여부 확인
        if(dto.memberFood().size() > 1){
            List<MemberFood> memberFoodList = new ArrayList<>();

            //id 별 음식 조회
            for(Long id : dto.memberFood()){
                // 음식 존재 여부 검증
                Food food = foodRepository.findById(id).orElseThrow(() -> new FoodException(FoodErrorCode.FOOD_NOT_FOUND));

                //MemberFood 엔티티 생성
                MemberFood memberFood = MemberFoodConverter.toMemberFood(member, food);

                //사용자 - 음식(선호 음식) 추가
                memberFoodList.add(memberFood);
            }
            // 모든 선호 음식 추가: DB 적용
            memberFoodRepository.saveAll(memberFoodList);
        }
        return MemberConverter.toJoinDTO(member);
    }
}
