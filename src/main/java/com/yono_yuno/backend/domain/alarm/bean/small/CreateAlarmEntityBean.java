package com.yono_yuno.backend.domain.alarm.bean.small;

import com.yono_yuno.backend.domain.alarm.entity.AlarmEntity;
import com.yono_yuno.backend.domain.cart.entity.AskCount;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateAlarmEntityBean {
    public AlarmEntity exec(UUID userId, UUID cartId, AskCount askCount, UUID diaryId) {
        return AlarmEntity.builder()
                .alarmId(UUID.randomUUID())
                .userId(userId)
                .cartId(cartId)
                .askCount(askCount)
                .diaryId(diaryId)
                .isCheck(false)
                .build();
    }
}
