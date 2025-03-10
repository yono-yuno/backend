package com.yono_yuno.backend.domain.item.bean.small;

import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import com.yono_yuno.backend.domain.item.entity.dto.ItemInfoDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateItemInfoDTOBean {
    public ItemInfoDTO exec(ItemEntity item) {
        return ItemInfoDTO.builder()
                .itemId(item.getItemId())
                .itemName(item.getItemName())
                .price(item.getPrice())
                .itemImg(item.getItemImg())
                .brandName(item.getBrandName())
                .build();
    }
}
