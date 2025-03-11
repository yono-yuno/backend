package com.yono_yuno.backend.domain.alarm.bean.small;

import com.yono_yuno.backend.domain.alarm.entity.AlarmEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateAlarmEntityBean {
    public AlarmEntity exec(AlarmEntity alarm) {
        alarm.setCheck(true);
        return alarm;
    }
}
