package com.yono_yuno.backend.domain.alarm.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class RequestUpdateAlarmDTO {
    UUID alarmId;
}
