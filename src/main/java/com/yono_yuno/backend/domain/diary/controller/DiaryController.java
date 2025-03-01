package com.yono_yuno.backend.domain.diary.controller;

import com.yono_yuno.backend.domain.diary.entity.dto.RequestSaveDiaryDTO;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetDiaryDTO;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseSaveDiaryDTO;
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
import java.util.Map;
import java.util.UUID;

@RestController
@Tag(name = "소비 일기 API", description = "소비 일기 관련 API")
@CrossOrigin("*")
@RequestMapping("/api/diary")
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) { this.diaryService = diaryService;}

    @Operation(summary = "일기 작성", description = "소비일기를 작성합니다.")
    @PostMapping("/write")

    public ResponseEntity<Map<String, Object>> write(@RequestBody RequestSaveDiaryDTO requestSaveDiaryDto) {
        ResponseSaveDiaryDTO responseSaveDiaryDto = diaryService.write(requestSaveDiaryDto);

        boolean success = responseSaveDiaryDto != null;
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", success);
        responseMap.put("message", success ? "소비 일기 작성 성공" : "소비 일기 작성 실패");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }
    @Operation(summary = "일기 조회", description = "소비일기를 조회합니다.")
    @PostMapping("/getdiary")

    public ResponseEntity<Map<String,Object>> getDiary(@RequestParam("diaryId")UUID diaryId){
        ResponseGetDiaryDTO responseGetDiaryDTO = diaryService.getDiary(diaryId);

        boolean success = responseGetDiaryDTO != null;
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "일기 조회 성공!" : "일기 조회 실패..");
        responseMap.put("userInfo", responseGetDiaryDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }

}
