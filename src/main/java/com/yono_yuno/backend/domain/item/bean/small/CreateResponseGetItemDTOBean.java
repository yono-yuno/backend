package com.yono_yuno.backend.domain.item.bean.small;

import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import com.yono_yuno.backend.domain.item.entity.dto.ResponseGetItemDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateResponseGetItemDTOBean {

    public ResponseGetItemDTO exec(ItemEntity item) {
        return ResponseGetItemDTO.builder()
                .itemId(item.getItemId())
                .itemName(item.getItemName())
                .brandName(item.getBrandName())
                .price(item.getPrice())
                .itemImg(item.getItemImg())
                .contentImg(item.getContentImg())
                .category(item.getCategory())
                .discount(item.getDiscount())
                .createAt(item.getCreatedAt())
                .itemStars(item.getItemStars())
                .reviewNum(item.getReviewNum())
                .build();
    }
}
