package com.yono_yuno.backend.domain.diary.entity;
import com.yono_yuno.backend.global.BaseEntity;
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
public class DiaryEntity extends BaseEntity {
    @Id
    UUID diaryId;
    UUID userId;
    double consumerStars;
    UUID itemId;
    String firstReview;
    String detailDiary;
}
