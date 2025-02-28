package com.yono_yuno.backend.domain.user.controller;

import com.yono_yuno.backend.domain.user.entity.dto.RequestSignUpDTO;
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
}
