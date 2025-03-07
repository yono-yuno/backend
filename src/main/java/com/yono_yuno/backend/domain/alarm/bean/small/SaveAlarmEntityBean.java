package com.yono_yuno.backend.domain.alarm.bean.small;

import com.yono_yuno.backend.domain.alarm.entity.AlarmEntity;
import com.yono_yuno.backend.domain.alarm.repository.AlarmRepositoryJPA;
import org.springframework.stereotype.Component;

@Component
public class SaveAlarmEntityBean {
    private final AlarmRepositoryJPA alarmRepositoryJPA;

    public SaveAlarmEntityBean(AlarmRepositoryJPA alarmRepositoryJPA) {
        this.alarmRepositoryJPA = alarmRepositoryJPA;
    }

    public void exec(AlarmEntity alarm) {
        alarmRepositoryJPA.save(alarm);
    }
}
