package com.yono_yuno.backend.domain.user.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseGetUserDTO {
    UUID userId;
    String userName;
    String phoneNum;
    int overPrice;
    String settingTime;
}
