package com.example.umc9thStudy.domain.mission.repository;

import com.example.umc9thStudy.domain.member.entity.Member;
import com.example.umc9thStudy.domain.mission.dto.res.MissionResponse;
import com.example.umc9thStudy.domain.mission.entity.MemberMission;
import com.example.umc9thStudy.domain.mission.entity.Mission;
import com.example.umc9thStudy.domain.mission.enums.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
/*
1주차 작성 쿼리

#진행 중
SELECT r.name, m.minimum_price, m.reward
FROM mission AS m
JOIN restaurant AS r ON r.restaurant_id = m.restaurant_id
JOIN attempt AS a
  ON a.mission_id = m.mission_id
  AND a.user_id = 현재 사용자 아이디
WHERE a.status = '진행중'
AND m.created_at < ? --이전 요청 응답의 마지막 행
ORDER BY m.mission_id DESC
LIMIT ?;


#진행 완료
SELECT r.name, m.minimum_price, m.reward
FROM mission AS m
JOIN restaurant AS r ON r.restaurant_id = m.restaurant_id
JOIN attempt AS a
  ON a.mission_id = m.mission_id
  AND a.user_id = 현재 사용자 아이디
WHERE a.status = '완료'
AND m.created_at < ? --이전 요청 응답의 마지막 행
ORDER BY m.mission_id DESC
LIMIT ?;
 */
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    @Query(
            // DTO로 r.name, m.minimumPrice, m.reward 조회하기
            "SELECT new com.example.umc9thStudy.domain.mission.dto.res.MissionResponse$MyMissionResponse(r.name, m.minimumPrice, m.rewardPoint)" +

                    //JPQL로 조회
                    "FROM MemberMission mm "+
                    "JOIN mm.mission m " +
                    "JOIN m.restaurant r "+

                    "WHERE mm.member.id = :userId " + //mm이 가진 m에 접근 후 id를 받아옴
                    "AND mm.status = :status " +

                    //페이징
                    "AND (:lastMissionId IS NULL OR m.id < :lastMissionId)" +

                    "ORDER BY m.id DESC"
    )
    List<MissionResponse.MyMissionResponse> findMyMission(
            @Param("userId") Long userId,
            @Param("status") Status status,
            @Param("lastMissionId") Long lastMissionId,
            Pageable pageable
    );

    long countByMemberIdAndStatus(Long memberId, Status status);

    boolean existsByMemberAndId(Member member, Mission mission);
}
