package com.yono_yuno.backend.domain.diary.controller;

import com.yono_yuno.backend.domain.diary.entity.dto.*;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetStatisticDTO;
import com.yono_yuno.backend.domain.diary.service.DiaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@Tag(name = "소비 일기 API", description = "소비 일기 관련 API")
@CrossOrigin("*")
@RequestMapping("/api/diary")
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @Operation(summary = "일기 작성", description = "소비일기를 작성합니다.")
    @PostMapping
    public ResponseEntity<Map<String, Object>> write(@RequestBody RequestCreateDiaryDTO requestCreateDiaryDto) {
        ResponseCreateDiaryDTO responseCreateDiaryDto = diaryService.write(requestCreateDiaryDto);

        boolean success = responseCreateDiaryDto != null;
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", success);
        responseMap.put("message", success ? "소비 일기 작성 성공" : "소비 일기 작성 실패");

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }

    @Operation(summary = "일기 조회", description = "소비일기를 조회합니다.")
    @GetMapping
    public ResponseEntity<Map<String,Object>> getDiary(@RequestParam("diaryId")UUID diaryId) {
        ResponseGetDiaryDTO responseGetDiaryDTO = diaryService.getDiary(diaryId);

        boolean success = responseGetDiaryDTO != null;
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "일기 조회 성공!" : "일기 조회 실패..");
        responseMap.put("DiaryInfo", responseGetDiaryDTO);

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    @Operation(summary = "일기 업데이트", description = "일기를 업데이트 합니다.")
    @PutMapping
    public ResponseEntity<Map<String,Object>> updateDiary(@RequestBody RequestUpdateDiaryDTO requestUpdateDiaryDTO) {
        boolean success = diaryService.update(requestUpdateDiaryDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "일기 변경 완료!" : "일기 변경 실패..");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    @Operation(summary = "일기 리스트 조회", description = "모든 일기를 조회 합니다.")
    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> getAllDiary(@RequestParam("userId") UUID userId,@RequestParam(value = "category", required = false, defaultValue = "전체") String category) {
       List<ResponseGetAllDiaryDTO> responseDiaryList = diaryService.getAllDiary(userId,category);

       boolean success = !responseDiaryList.isEmpty();
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "일기 리스트 조회 성공" : "일기 리스트 조회 실패");
        responseMap.put("diaryList", responseDiaryList);

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    @Operation(summary = "통계 조회", description = "통계 정보를 반환합니다.")
    @GetMapping("/statistic")
    public ResponseEntity<Map<String,Object>> statistic(@RequestParam("userId") UUID userId) {
        ResponseGetStatisticDTO responseStatistic = diaryService.statistic(userId);

        boolean success = responseStatistic != null;
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "통계 조회 성공" : "통계 조회 실패");
        responseMap.put("statistic", responseStatistic);

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }
}
