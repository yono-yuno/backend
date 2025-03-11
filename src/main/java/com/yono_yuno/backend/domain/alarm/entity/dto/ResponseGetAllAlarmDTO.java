package com.yono_yuno.backend.domain.alarm.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseGetAllAlarmDTO {
    UUID alarmId;
    String itemName;
    String nextPageName;
    String alarmTime;
}
