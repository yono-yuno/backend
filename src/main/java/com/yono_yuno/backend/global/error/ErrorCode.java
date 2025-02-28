package com.yono_yuno.backend.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, false, "USER-001", "사용자를 찾을 수 없습니다."),
    USER_IS_EXIST(HttpStatus.BAD_REQUEST, false, "USER-002", "이미 유저가 존재합니다."),
    ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, false, "ACCOUNT-001", "계좌를 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final boolean isSuccess;
    private final String code;
    private final String message;
}
