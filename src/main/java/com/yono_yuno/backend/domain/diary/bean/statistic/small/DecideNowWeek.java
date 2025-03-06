package com.yono_yuno.backend.domain.diary.bean.statistic.small;

import com.yono_yuno.backend.domain.diary.bean.small.GetDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.UUID;

public class DecideNowWeek {
    private final GetDiaryEntityBean getDiaryEntityBean;

    public DecideNowWeek(GetDiaryEntityBean getDiaryEntityBean) {
        this.getDiaryEntityBean = getDiaryEntityBean;
    }

    public boolean exec(UUID diaryId) {
        LocalDate today = LocalDate.now();

        LocalDate startOfWeek = today.with(WeekFields.of(Locale.US).dayOfWeek(), 7);

        LocalDate endOfWeek = startOfWeek.plusDays(6);

        DiaryEntity diary = getDiaryEntityBean.exec(diaryId);

        LocalDate createdAt = diary.getCreatedAt().toLocalDate();

        // createdAt이 이번 주에 포함되는지 확인
        return !createdAt.isBefore(startOfWeek) && !createdAt.isAfter(endOfWeek);
    }
}

