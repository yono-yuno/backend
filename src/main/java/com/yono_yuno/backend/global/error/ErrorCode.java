package com.yono_yuno.backend.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    CURRENT_NOT_FOUND(HttpStatus.NOT_FOUND, false, "STATISTIC-001", "이번 달 통계 정보를 찾을 수 없습니다."),
    PREV_NOT_FOUND(HttpStatus.NOT_FOUND, false, "STATISTIC-002", "저번 달 통계 정보를 찾을 수 없습니다."),
    LINE_NOT_CREATE(HttpStatus.NOT_FOUND, false, "STATISTIC-003", "선 그래프 정보를 만들 수 없습니다."),
    PIE_NOT_CREATE(HttpStatus.NOT_FOUND, false, "STATISTIC-004", "파이 그래프 정보를 만들 수 없습니다."),
    DATE_PRICE_MATCHING_FAIL(HttpStatus.NOT_FOUND, false, "STATISTIC-005", "날짜와 금액 매칭을 실패했습니다."),
    CART_NOT_FOUND(HttpStatus.NOT_FOUND, false, "CART-001", "카트(단일)을 찾을 수 없습니다."),
    CART_NOT_IN(HttpStatus.NOT_FOUND, false, "CART-002", "상품을 카트에 넣을 수 없습니다."),
    CART_TIME_NOT_FOUND(HttpStatus.NOT_FOUND, false, "CART-003", "카트 시간을 찾을 수 없습니다."),
    ASK_COUNT_INDEX_ERROR(HttpStatus.NOT_FOUND, false, "CART-004", "카트 시간을 찾을 수 없습니다."),
    DIARY_NOT_FOUND(HttpStatus.NOT_FOUND, false, "DIARY-001", "소비 일기를 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, false, "USER-001", "사용자를 찾을 수 없습니다."),
    USER_TIME_NOT_FOUND(HttpStatus.NOT_FOUND, false, "USER-002", "사용자가 설정한 시간을  찾을 수 없습니다."),
    USER_IS_EXIST(HttpStatus.BAD_REQUEST, false, "USER-002", "이미 유저가 존재합니다."),
    ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, false, "ACCOUNT-001", "계좌를 찾을 수 없습니다."),
    ITEM_NOT_FOUND(HttpStatus.NOT_FOUND, false, "ITEM-001", "상품을 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final boolean isSuccess;
    private final String code;
    private final String message;
}
