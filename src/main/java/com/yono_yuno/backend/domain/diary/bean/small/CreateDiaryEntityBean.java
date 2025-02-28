package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.RequestSaveDiaryDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component

public class CreateDiaryEntityBean {
    public DiaryEntity exec(RequestSaveDiaryDto requestSaveDiaryDto) {
        return DiaryEntity.builder()
                .diaryId(UUID.randomUUID())
                .firstReview(requestSaveDiaryDto.getFirstReview())
                .itemId(requestSaveDiaryDto.getItemId())
                .userId(requestSaveDiaryDto.getUserId())
                .build();
    }
}
