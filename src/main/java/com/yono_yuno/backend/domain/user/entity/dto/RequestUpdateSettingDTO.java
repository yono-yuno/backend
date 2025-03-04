package com.yono_yuno.backend.domain.user.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class RequestUpdateSettingDTO {
    UUID userId;
    int overPrice;
    String settingTime;
}
