package com.yono_yuno.backend.domain.diary.repository;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface DiaryRepositoryJpa extends JpaRepository<DiaryEntity, UUID> {
}
