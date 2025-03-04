package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.repository.DiaryRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetAllDiaryEntityBean {
    private final DiaryRepositoryJPA diaryRepositoryJpa;

    public GetAllDiaryEntityBean(DiaryRepositoryJPA diaryRepositoryJpa){
        this.diaryRepositoryJpa=diaryRepositoryJpa;
    }
//cart 완성시 결제 상태가 3(BUY)상태인것만 출력해야함
    public List<DiaryEntity> exec(UUID userId) {
        return diaryRepositoryJpa.findAllByUserId(userId);
    }
}
