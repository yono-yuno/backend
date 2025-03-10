package com.yono_yuno.backend.domain.alarm.bean;

import com.yono_yuno.backend.domain.alarm.bean.small.GetAlarmEntityBean;
import com.yono_yuno.backend.domain.alarm.bean.small.SaveAlarmEntityBean;
import com.yono_yuno.backend.domain.alarm.bean.small.UpdateAlarmEntityBean;
import com.yono_yuno.backend.domain.alarm.entity.AlarmEntity;
import com.yono_yuno.backend.domain.alarm.entity.dto.RequestUpdateAlarmDTO;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateAlarmBean {
    private final GetAlarmEntityBean getAlarmEntityBean;
    private final UpdateAlarmEntityBean updateAlarmEntityBean;
    private final SaveAlarmEntityBean saveAlarmEntityBean;

    public UpdateAlarmBean(GetAlarmEntityBean getAlarmEntityBean, UpdateAlarmEntityBean updateAlarmEntityBean, SaveAlarmEntityBean saveAlarmEntityBean) {
        this.getAlarmEntityBean = getAlarmEntityBean;
        this.updateAlarmEntityBean = updateAlarmEntityBean;
        this.saveAlarmEntityBean = saveAlarmEntityBean;
    }

    public boolean exec(RequestUpdateAlarmDTO requestUpdateAlarmDTO) {
        AlarmEntity alarm = getAlarmEntityBean.exec(requestUpdateAlarmDTO.getAlarmId());

        if (alarm == null) {
            throw new CustomException(ErrorCode.ALARM_NOT_FOUND);
        }

        if (alarm.isCheck()) {
            throw new CustomException(ErrorCode.ALARM_IS_EXIST);
        }

        AlarmEntity updateAlarm = updateAlarmEntityBean.exec(alarm);

        if (updateAlarm == null) {
            return false;
        }

        saveAlarmEntityBean.exec(updateAlarm);

        return true;
    }
}
