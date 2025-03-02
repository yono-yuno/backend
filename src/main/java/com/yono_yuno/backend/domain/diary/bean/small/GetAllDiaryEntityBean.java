package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.repository.DiaryRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class GetAllDiaryEntityBean {
    private final DiaryRepositoryJpa diaryRepositoryJpa;

    public GetAllDiaryEntityBean(DiaryRepositoryJpa diaryRepositoryJpa){
        this.diaryRepositoryJpa=diaryRepositoryJpa;
    }

    public List<DiaryEntity>  exec() {
        return diaryRepositoryJpa.findAll();
    }
}
