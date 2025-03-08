package com.yono_yuno.backend.domain.alarm.service;

import com.yono_yuno.backend.domain.alarm.bean.GetAllAlarmBean;
import com.yono_yuno.backend.domain.alarm.bean.UpdateAlarmBean;
import com.yono_yuno.backend.domain.alarm.entity.dto.RequestUpdateAlarmDTO;
import com.yono_yuno.backend.domain.alarm.entity.dto.ResponseGetAllAlarmDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlarmService {
    private final GetAllAlarmBean getAllAlarmBean;
    private final UpdateAlarmBean updateAlarmBean;

    public AlarmService(GetAllAlarmBean getAllAlarmBean, UpdateAlarmBean updateAlarmBean) {
        this.getAllAlarmBean = getAllAlarmBean;
        this.updateAlarmBean = updateAlarmBean;
    }

    public List<ResponseGetAllAlarmDTO> getAllAlarmByUserId(UUID userId) {
        return getAllAlarmBean.exec(userId);
    }

    public boolean updateAlarm(RequestUpdateAlarmDTO requestUpdateAlarmDTO) {
        return updateAlarmBean.exec(requestUpdateAlarmDTO);
    }
}