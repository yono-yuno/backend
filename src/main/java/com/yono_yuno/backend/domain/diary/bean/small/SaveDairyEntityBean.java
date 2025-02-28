package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.repository.DiaryRepositoryJpa;
import org.springframework.stereotype.Component;

@Component

public class SaveDairyEntityBean {
    private final DiaryRepositoryJpa diaryRepositoryJpa;

    public SaveDairyEntityBean(DiaryRepositoryJpa diaryRepositoryJpa) {
        this.diaryRepositoryJpa = diaryRepositoryJpa;
    }

    public void exec(DiaryEntity diaryEntity) {
        diaryRepositoryJpa.save(diaryEntity);
    }
}
