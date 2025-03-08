package com.yono_yuno.backend.domain.item.entity;

import com.yono_yuno.backend.global.BaseEntity;
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
public class ItemEntity extends BaseEntity {
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
    int discount;
}

