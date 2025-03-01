package com.yono_yuno.backend.domain.diary.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
//item 완성 시 정보 불러오기 추가 예정
public class GetItemInfo {
    UUID itemId;
    String category;
    String itemName;
    String brandName;
    String itemImg;
    int price;
}
