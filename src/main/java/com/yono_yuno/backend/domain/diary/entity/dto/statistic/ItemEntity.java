package com.yono_yuno.backend.domain.diary.entity.dto.statistic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ItemEntity {
    @Id
    UUID itemId;
    String itemName;
    String brandName;
    int price;
    String itemImg;
    String contentImg;
    String category;
    double itemStars;
    int reviewNum;
    LocalDateTime createAt;
    LocalDateTime updateAt;
    int discount;

}