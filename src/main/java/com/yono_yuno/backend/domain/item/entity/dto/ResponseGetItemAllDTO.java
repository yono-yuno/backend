package com.yono_yuno.backend.domain.item.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ResponseGetItemAllDTO {
    UUID itemId;
    String itemName;
    int price;
    String itemImg;
    String category;
    int discount;
    LocalDateTime createdAt;
    double itemStars;
    int reviewNum;
}
