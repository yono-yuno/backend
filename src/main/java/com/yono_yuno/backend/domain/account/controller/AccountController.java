package com.yono_yuno.backend.domain.account.controller;

import com.yono_yuno.backend.domain.account.entity.dto.RequestUpdateAccountDTO;
import com.yono_yuno.backend.domain.account.entity.dto.ResponseGetAccountDTO;
import com.yono_yuno.backend.domain.account.service.AccountService;
import com.yono_yuno.backend.domain.cart.entity.dto.RequestUpdateCartDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.HttpStatus;

@CrossOrigin("*")
@RequestMapping("/api/account")
@Tag(name = "계좌 조회 API", description = "계좌 조회 관련 API")
@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Operation(summary = "계좌 조회", description = "userId로 해당 계좌의 정보를 조회합니다.")
    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAccount(@RequestParam("userId") UUID userId) {
        ResponseGetAccountDTO responseGetAccountDTO = accountService.getAccount(userId);

        boolean success = responseGetAccountDTO != null;

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "계좌 조회 성공!" : "계좌 조회 실패..");
        responseMap.put("accountInfo", responseGetAccountDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }

    @Operation(summary = "계좌 잔액 업데이트", description = "계좌 잔액을 업데이트 합니다.")
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateBalance(@RequestBody RequestUpdateAccountDTO requestUpdateAccountDTO) {
        boolean success= accountService.updateBalance(requestUpdateAccountDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "계좌 잔액 업데이트 성공" : "계좌 잔액 업데이트 실패");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

}
