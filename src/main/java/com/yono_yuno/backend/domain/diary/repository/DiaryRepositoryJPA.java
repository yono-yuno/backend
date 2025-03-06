package com.yono_yuno.backend.domain.diary.repository;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.YearMonth;
import java.util.List;
import java.util.UUID;
public interface DiaryRepositoryJPA extends JpaRepository<DiaryEntity, UUID> {
    DiaryEntity findByUserId(UUID userId);
    List<DiaryEntity> findAllByUserId(UUID userId);

    @Query("SELECT d FROM DiaryEntity d WHERE d.userId = :userId AND FUNCTION('YEAR_MONTH', d.createdAt) = :yearMonth")
    List<DiaryEntity> findAllByUserIdAndMonth(@Param("userId") UUID userId, @Param("yearMonth") YearMonth yearMonth);
}
