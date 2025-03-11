package com.yono_yuno.backend.domain.item.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ItemInfoDTO {
    UUID itemId;
    String itemName;
    int price;
    String itemImg;
    String brandName;
}
