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
//cart 완성시 결제 상태가 3(BUY)상태인것만 출력해야함
    public List<DiaryEntity>  exec() {
        return diaryRepositoryJpa.findAll();
    }
}
