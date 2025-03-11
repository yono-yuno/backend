package com.yono_yuno.backend.domain.alarm.repository;

import com.yono_yuno.backend.domain.alarm.entity.AlarmEntity;
import com.yono_yuno.backend.domain.cart.entity.AskCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.List;

public interface AlarmRepositoryJPA extends JpaRepository<AlarmEntity, UUID> {
    List<AlarmEntity> findAllByUserIdAndIsCheckFalseOrderByCreatedAtDesc(UUID userId);
    AlarmEntity findFirstByUserIdAndCartIdAndAskCount(UUID userId, UUID cartId, AskCount askCount);
    AlarmEntity findFirstByUserIdAndDiaryId(UUID userId, UUID diaryId);
}
