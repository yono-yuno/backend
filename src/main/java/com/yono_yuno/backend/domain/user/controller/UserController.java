package com.yono_yuno.backend.domain.user.controller;

import com.yono_yuno.backend.domain.user.entity.dto.RequestUpdateSettingDTO;
import com.yono_yuno.backend.domain.user.entity.dto.RequestLoginDTO;
import com.yono_yuno.backend.domain.user.entity.dto.RequestSignUpDTO;
import com.yono_yuno.backend.domain.user.entity.dto.ResponseLoginDTO;
import com.yono_yuno.backend.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "유저 API", description = "유저 관련 API")
@RequestMapping("/api/user")
@CrossOrigin("*")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signUp(@RequestBody RequestSignUpDTO requestSignUpDTO) {
        boolean success = userService.signUp(requestSignUpDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "회원가입 성공!" : "회원가입 실패..");

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }

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

    @PutMapping("")
    public ResponseEntity<Map<String, Object>> updateSetting(@RequestBody RequestUpdateSettingDTO requestUpdateSettingDTO) {
        boolean success = userService.updateSetting(requestUpdateSettingDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "설정 변경 완료!" : "설정 변경 실패..");

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }
}
