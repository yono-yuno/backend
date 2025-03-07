package com.yono_yuno.backend.domain.alarm.controller;

import com.yono_yuno.backend.domain.alarm.entity.dto.ResponseGetAllAlarmDTO;
import com.yono_yuno.backend.domain.alarm.service.AlarmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Tag(name = "알람 API", description = "알람 관련 API")
@RequestMapping("/api/alarm")
@CrossOrigin("http://localhost:5173")
@RestController
public class AlarmController {
    private final AlarmService alarmService;

    public AlarmController(AlarmService alarmService) {
        this.alarmService = alarmService;
    }

    @Operation(summary = "알람 조회", description = "특정 유저의 알람을 조회합니다.")
    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAlarmByUserId(@RequestParam("userId")UUID userId) {
        List<ResponseGetAllAlarmDTO> alarmList = alarmService.getAllAlarmByUserId(userId);

        boolean success = !alarmList.isEmpty();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "알림조회 성공!" : "알림조회 실패...");
        responseMap.put("alarmList", alarmList);

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }
}