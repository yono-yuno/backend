package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateDiaryEntityBean {
    public DiaryEntity exec(DiaryEntity diary, double consumerStars, String detailDiary){
        diary.setConsumerStars(consumerStars);
        diary.setDetailDiary(detailDiary);

        return diary;
    }
}
