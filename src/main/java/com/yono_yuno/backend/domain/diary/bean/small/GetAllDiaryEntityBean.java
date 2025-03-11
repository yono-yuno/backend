package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.repository.DiaryRepositoryJPA;
import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class GetAllDiaryEntityBean {
    private final DiaryRepositoryJPA diaryRepositoryJPA;

    public GetAllDiaryEntityBean(DiaryRepositoryJPA diaryRepositoryJPA) {
        this.diaryRepositoryJPA = diaryRepositoryJPA;
    }

    public List<DiaryEntity> exec(UUID userId) {
        return diaryRepositoryJPA.findAllByUserId(userId);
    }

    public List<DiaryEntity> exec(UUID userId, String category) {
        return diaryRepositoryJPA.findAllByUserId(userId);
    }

    public List<DiaryEntity> exec(UUID userId, LocalDateTime afterThreeDays) {
        return diaryRepositoryJPA.findAllByUserIdAndCreatedAtBefore(userId, afterThreeDays);
    }
}
