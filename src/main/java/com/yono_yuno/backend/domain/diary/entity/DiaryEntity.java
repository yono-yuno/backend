package com.yono_yuno.backend.domain.diary.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiaryEntity {
    @Id
    UUID diaryId;
    UUID userId;
    double consumerStars;
    UUID itemId;
    String firstReview;
    String detailDiary;
}
