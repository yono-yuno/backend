package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.repository.DiaryRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetDiaryEntityBean {
    private final DiaryRepositoryJpa diaryRepositoryJpa;

    public GetDiaryEntityBean(DiaryRepositoryJpa diaryRepositoryJpa) {
        this.diaryRepositoryJpa=diaryRepositoryJpa;
    }

    public DiaryEntity exec(UUID diaryId){
        return diaryRepositoryJpa.findById(diaryId).orElse(null);
    }
}
