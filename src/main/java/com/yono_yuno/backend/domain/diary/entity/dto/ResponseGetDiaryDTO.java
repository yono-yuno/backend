package com.yono_yuno.backend.domain.diary.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
// item 완성하면 GetItemInfo 불러오기 해야함
public class ResponseGetDiaryDTO {
    UUID diaryId;
    UUID userId;
    double consumerStars;
    String firstReview;
    String detailDiary;
    GetItemInfo itemInfo;
}
