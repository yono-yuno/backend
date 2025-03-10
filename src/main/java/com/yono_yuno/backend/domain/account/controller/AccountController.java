package com.yono_yuno.backend.domain.account.controller;

import com.yono_yuno.backend.domain.account.entity.dto.ResponseGetAccountDTO;
import com.yono_yuno.backend.domain.account.service.AccountService;
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

    @Operation(summary = "계좌 조회", description = "accountID로 해당 계좌의 정보를 조회합니다.")
    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAccount(@RequestParam("AccountId") UUID accountId) {
        ResponseGetAccountDTO responseGetAccountDTO = accountService.getAccount(accountId);

        boolean success = responseGetAccountDTO != null;

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "계좌 조회 성공!" : "계좌 조회 실패..");
        responseMap.put("accountInfo", responseGetAccountDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }
}
