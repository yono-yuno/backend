package com.yono_yuno.backend.domain.cart.entity.dto;

import com.yono_yuno.backend.domain.cart.entity.AskCount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestCreateCartDTO {
    UUID userId;
    UUID itemId;
    int askCount;
}
