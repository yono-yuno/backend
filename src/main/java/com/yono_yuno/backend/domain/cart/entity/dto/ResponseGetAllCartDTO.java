package com.yono_yuno.backend.domain.cart.entity.dto;

import com.yono_yuno.backend.domain.cart.entity.AskCount;
import com.yono_yuno.backend.domain.cart.entity.dto.GetItemInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.DocFlavor;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseGetAllCartDTO {
    UUID cartId;
    UUID userId;
    AskCount askCount;
    LocalDateTime createdAt;
    String extraTime;
    GetItemInfo itemInfo;

}
