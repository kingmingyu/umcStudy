package com.example.umc9thStudy.domain.member.repository;

import com.example.umc9thStudy.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
