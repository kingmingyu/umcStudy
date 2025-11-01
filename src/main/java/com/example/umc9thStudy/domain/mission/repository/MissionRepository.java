package com.example.umc9thStudy.domain.mission.repository;

import com.example.umc9thStudy.domain.mission.dto.HomeResponseDto;
import com.example.umc9thStudy.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    @Query(
        "SELECT new com.example.umc9thStudy.domain.mission.dto.HomeResponseDto(m.id, r.name, m.rewardPoint, m.minimumPrice) " +


            "FROM Mission m " +
            "JOIN m.restaurant r " +


            "WHERE r.region.id = :regionId AND m.isActive = 1"
    )
    Page<HomeResponseDto> findAvailableMissionsByRegion(
            @Param("regionId") Long regionId,
            Pageable pageable //
    );
}
