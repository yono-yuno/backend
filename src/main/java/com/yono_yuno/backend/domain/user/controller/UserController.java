package com.yono_yuno.backend.domain.user.controller;

import com.yono_yuno.backend.domain.user.entity.dto.*;
import com.yono_yuno.backend.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Tag(name = "유저 API", description = "유저 관련 API")
@RequestMapping("/api/user")
@CrossOrigin("*")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "회원가입", description = "유저의 정보를 받아서 회원가입을 진행합니다.")
    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signUp(@RequestBody RequestSignUpDTO requestSignUpDTO) {
        boolean success = userService.signUp(requestSignUpDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "회원가입 성공!" : "회원가입 실패..");

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }

    @Operation(summary = "로그인", description = "휴대폰번호와 비밀번호로 로그인을 진행합니다.")
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody RequestLoginDTO requestLoginDTO) {
        ResponseLoginDTO responseLoginDTO = userService.login(requestLoginDTO);

        boolean success = requestLoginDTO != null;

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "로그인 성공!" : "로그인 실패..");
        responseMap.put("userInfo", responseLoginDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }

    @Operation(summary = "설정 변경", description = "유저의 상한액, 전체 고민시간 설정을 변경합니다.")
    @PutMapping()
    public ResponseEntity<Map<String, Object>> updateSetting(@RequestBody RequestUpdateSettingDTO requestUpdateSettingDTO) {
        boolean success = userService.updateSetting(requestUpdateSettingDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "설정 변경 완료!" : "설정 변경 실패..");

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }

    @Operation(summary = "유저 조회", description = "userId로 해당 유저의 정보를 조회합니다.")
    @GetMapping()
    public ResponseEntity<Map<String, Object>> getUser(@RequestParam("userId")UUID userId) {
        ResponseGetUserDTO responseGetUserDTO = userService.getUser(userId);

        boolean success = responseGetUserDTO != null;

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "유저 조회 성공!" : "유저 조회 실패..");
        responseMap.put("userInfo", responseGetUserDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }
}
