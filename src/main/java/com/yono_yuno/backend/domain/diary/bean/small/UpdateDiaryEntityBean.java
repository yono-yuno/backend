package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateDiaryEntityBean {
    public DiaryEntity exec(DiaryEntity diary, double consumerStars, String firstReview, String detailDiary){
        diary.setConsumerStars(consumerStars);
        diary.setFirstReview(firstReview);
        diary.setDetailDiary(detailDiary);

        return diary;
    }
}
