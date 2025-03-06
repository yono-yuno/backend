package com.yono_yuno.backend.domain.diary.bean.statistic.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.repository.DiaryRepositoryJPA;
import org.springframework.stereotype.Component;

import java.time.YearMonth;
import java.util.List;
import java.util.UUID;

@Component
public class GetAllMonthDiaryEntityBean {
    private final DiaryRepositoryJPA diaryRepositoryJPA;

    public GetAllMonthDiaryEntityBean(DiaryRepositoryJPA diaryRepositoryJPA){
        this.diaryRepositoryJPA=diaryRepositoryJPA;
    }
    public List<DiaryEntity> exec(UUID diaryId, YearMonth yearMonth) {
        return diaryRepositoryJPA.findAllByUserIdAndMonth(diaryId, yearMonth);
    }
}
