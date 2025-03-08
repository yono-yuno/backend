package com.yono_yuno.backend.domain.alarm.bean.small;

import com.yono_yuno.backend.domain.alarm.entity.AlarmEntity;

public class UpdateAlarmEntityBean {
    public AlarmEntity exec(AlarmEntity alarm) {
        alarm.setCheck(true);
        return alarm;
    }
}
