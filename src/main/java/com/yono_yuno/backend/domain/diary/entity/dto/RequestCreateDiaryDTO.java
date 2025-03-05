package com.yono_yuno.backend.domain.diary.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestCreateDiaryDTO {
    UUID userId;
    UUID itemId;
    String firstReview;
}
