package com.yono_yuno.backend.domain.diary.repository;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
public interface DiaryRepositoryJPA extends JpaRepository<DiaryEntity, UUID> {
    DiaryEntity findByUserId(UUID userId);
    List<DiaryEntity> findAllByUserId(UUID userId);
    List<DiaryEntity> findAllByUserIdAndCreatedAtBefore(UUID userId, LocalDateTime createdAt);
}
