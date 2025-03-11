package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.RequestCreateDiaryDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateDiaryEntityBean {
    public DiaryEntity exec(RequestCreateDiaryDTO requestCreateDiaryDto) {
        return DiaryEntity.builder()
                .diaryId(UUID.randomUUID())
                .firstReview(requestCreateDiaryDto.getFirstReview())
                .itemId(requestCreateDiaryDto.getItemId())
                .userId(requestCreateDiaryDto.getUserId())
                .build();
    }
}
