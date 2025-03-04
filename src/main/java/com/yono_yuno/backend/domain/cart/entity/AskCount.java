package com.yono_yuno.backend.domain.cart.entity;

import lombok.*;

@Getter


public enum AskCount {
    FIRST_THINK(1),
    SECOND_THINK(2),
    BUY(3),
    CANCEL(4);

    private final int value;

    AskCount(int value){
        this.value=value;
    }

    public int getvalue(){
        return value;
    }

    public static AskCount fromValue(int value){
        for(AskCount count : AskCount.values()){
            if(count.value==value){
                return count;
            }
        }
        throw new IllegalArgumentException("enum 범위 에러 " + value);
    }
}
