package com.yono_yuno.backend.domain.alarm.bean.small;

import com.yono_yuno.backend.domain.alarm.entity.AlarmEntity;
import com.yono_yuno.backend.domain.alarm.entity.dto.ResponseGetAllAlarmDTO;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class CreateResponseGetAllAlarmDTOBean {
    // Item 구현 완료 후 추가 예정
    public ResponseGetAllAlarmDTO exec(AlarmEntity alarm) {
        DateTimeFormatter alarmTimeFormatter = DateTimeFormatter.ofPattern("yy.MM.dd/HH:mm");

        return ResponseGetAllAlarmDTO.builder()
                .alarmId(alarm.getAlarmId())
                .itemName("상품이름")
                .nextPageName(alarm.getDiaryId() == null ? "cart" : "diary")
                .alarmTime(alarm.getCreatedAt().format(alarmTimeFormatter))
                .build();
    }
}
