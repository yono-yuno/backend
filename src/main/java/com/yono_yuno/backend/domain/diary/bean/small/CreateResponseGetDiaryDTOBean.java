package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.GetItemInfo;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetDiaryDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateResponseGetDiaryDTOBean {
    public ResponseGetDiaryDTO exec(DiaryEntity diary){
        return ResponseGetDiaryDTO.builder()
                .diaryId(diary.getDiaryId())
                .userId(diary.getUserId())
                .consumerStars(diary.getConsumerStars())
                .firstReview(diary.getFirstReview())
                .detailDiary(diary.getDetailDiary())
                .itemInfo(GetItemInfo.builder().build())
                .build();
    }

}
