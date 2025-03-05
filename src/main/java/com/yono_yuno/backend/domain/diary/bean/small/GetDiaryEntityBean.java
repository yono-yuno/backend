package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.repository.DiaryRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetDiaryEntityBean {
    private final DiaryRepositoryJPA diaryRepositoryJpa;

    public GetDiaryEntityBean(DiaryRepositoryJPA diaryRepositoryJpa) {
        this.diaryRepositoryJpa=diaryRepositoryJpa;
    }

    public DiaryEntity exec(UUID diaryId){
        return diaryRepositoryJpa.findById(diaryId).orElse(null);
    }
}
