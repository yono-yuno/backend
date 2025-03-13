package com.yono_yuno.backend.domain.cart.entity.dto;

import com.yono_yuno.backend.domain.item.entity.dto.ItemInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ResponseGetCartDTO {
    ItemInfoDTO itemInfo;
    int askCount;
}
