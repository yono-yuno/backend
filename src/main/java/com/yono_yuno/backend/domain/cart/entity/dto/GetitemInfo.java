package com.yono_yuno.backend.domain.cart.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetItemInfo {
    UUID itemId;
    String itemName;
    int price;
    String itemImg;
    String brandName;
}
