package com.yono_yuno.backend.domain.item.bean.small;

import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import com.yono_yuno.backend.domain.item.entity.dto.ResponseGetItemAllDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateResponseGetItemAllDTOBean {
    public ResponseGetItemAllDTO exec(ItemEntity item) {
        return ResponseGetItemAllDTO.builder()
                .itemId(item.getItemId())
                .itemName(item.getItemName())
                .price(item.getPrice())
                .itemImg(item.getItemImg())
                .category(item.getCategory())
                .discount(item.getDiscount())
                .createdAt(item.getCreatedAt())
                .itemStars(item.getItemStars())
                .reviewNum(item.getReviewNum())
                .build();
    }
}
