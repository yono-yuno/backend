package com.yono_yuno.backend.domain.user.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseLoginDTO {
    UUID userId;
    String userName;
}
