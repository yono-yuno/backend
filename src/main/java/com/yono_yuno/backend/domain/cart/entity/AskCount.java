package com.yono_yuno.backend.domain.cart.entity;

import lombok.*;

@Getter
public enum AskCount {
    FIRST_THINK(0),
    SECOND_THINK(1),
    BUY(2),
    CANCEL(3);

    private final int value;

    AskCount(int value) {
        this.value = value;
    }
}