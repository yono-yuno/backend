package com.yono_yuno.backend.domain.diary.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class RequestUpdateDiaryDTO {
    UUID dairyId;
    double consumerStars;
    String detailDiary;

}
