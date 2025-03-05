package com.yono_yuno.backend.domain.cart.entity.dto;

import com.yono_yuno.backend.domain.cart.entity.AskCount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseCreateCartDTO {
    UUID cartId;
    UUID userId;
    UUID itemId;
    LocalDateTime createAt;
    AskCount askCount;
}
