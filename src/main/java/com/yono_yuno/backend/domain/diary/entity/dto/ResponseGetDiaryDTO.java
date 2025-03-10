package com.yono_yuno.backend.domain.diary.entity.dto;

import com.yono_yuno.backend.domain.item.entity.dto.ItemInfoDTO;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseGetDiaryDTO {
    UUID diaryId;
    UUID userId;
    double consumerStars;
    String firstReview;
    String detailDiary;
    ItemInfoDTO itemInfo;
}
