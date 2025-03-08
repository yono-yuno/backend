package com.yono_yuno.backend.domain.alarm.bean.small;

import com.yono_yuno.backend.domain.alarm.entity.AlarmEntity;
import com.yono_yuno.backend.domain.alarm.repository.AlarmRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetAllAlarmEntityBean {
    private final AlarmRepositoryJPA alarmRepositoryJPA;

    public GetAllAlarmEntityBean(AlarmRepositoryJPA alarmRepositoryJPA) {
        this.alarmRepositoryJPA = alarmRepositoryJPA;
    }

    public List<AlarmEntity> exec(UUID userId) {
        return alarmRepositoryJPA.findAllByUserIdAndIsCheckFalseOrderByCreatedAtDesc(userId);
    }
}
