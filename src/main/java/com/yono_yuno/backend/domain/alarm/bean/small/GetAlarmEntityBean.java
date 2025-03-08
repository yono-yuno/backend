package com.yono_yuno.backend.domain.alarm.bean.small;

import com.yono_yuno.backend.domain.alarm.entity.AlarmEntity;
import com.yono_yuno.backend.domain.alarm.repository.AlarmRepositoryJPA;
import com.yono_yuno.backend.domain.cart.entity.AskCount;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetAlarmEntityBean {
    private final AlarmRepositoryJPA alarmRepositoryJPA;

    public GetAlarmEntityBean(AlarmRepositoryJPA alarmRepositoryJPA) {
        this.alarmRepositoryJPA = alarmRepositoryJPA;
    }

    public AlarmEntity exec(UUID alarmId) {
        return alarmRepositoryJPA.findById(alarmId).orElse(null);
    }

    public AlarmEntity exec(UUID userId, UUID cartId, AskCount askCount) {
        return alarmRepositoryJPA.findByUserIdAndCartIdAndAskCount(userId, cartId, askCount);
    }

    public AlarmEntity exec(UUID userId, UUID diaryId) {
        return alarmRepositoryJPA.findByUserIdAndDiaryId(userId, diaryId);
    }
}
