package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseSaveDiaryDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateDiaryDtoBean {
    public ResponseSaveDiaryDTO exec(DiaryEntity diaryEntity){
        return ResponseSaveDiaryDTO.builder()
                .diaryId(diaryEntity.getDiaryId())
                .firstReview(diaryEntity.getFirstReview())
                .itemId(diaryEntity.getItemId())
                .userId(diaryEntity.getUserId())
                .build();
    }
}
