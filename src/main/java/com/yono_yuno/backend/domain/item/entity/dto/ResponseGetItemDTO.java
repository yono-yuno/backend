package com.yono_yuno.backend.domain.item.entity.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

//@Data
@Builder
public class ResponseGetItemDTO {
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
    int discount;


}
