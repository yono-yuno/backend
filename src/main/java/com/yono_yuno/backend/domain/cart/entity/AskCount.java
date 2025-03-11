package com.yono_yuno.backend.domain.cart.entity;

import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import lombok.*;

public enum AskCount {
    FIRST_THINK,
    SECOND_THINK,
    BUY,
    CANCEL;
}
