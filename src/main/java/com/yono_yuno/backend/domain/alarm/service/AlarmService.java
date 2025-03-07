package com.yono_yuno.backend.domain.alarm.service;

import com.yono_yuno.backend.domain.alarm.bean.GetAllAlarmBean;
import com.yono_yuno.backend.domain.alarm.entity.dto.ResponseGetAllAlarmDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlarmService {
    private final GetAllAlarmBean getAllAlarmBean;

    public AlarmService(GetAllAlarmBean getAllAlarmBean) {
        this.getAllAlarmBean = getAllAlarmBean;
    }

    public List<ResponseGetAllAlarmDTO> getAllAlarmByUserId(UUID userId) {
        return getAllAlarmBean.exec(userId);
    }
}
