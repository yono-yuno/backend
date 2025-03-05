package com.yono_yuno.backend.domain.cart.entity;

import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
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


    public static AskCount fromValue(int value){
        for(AskCount count : AskCount.values()){
            if(count.value==value){
                return count;
            }
        }
        throw new CustomException(ErrorCode.ASKCOUNT_INDEX_ERROR);
    }
    public static AskCount changeStatus(int newValue){
        return fromValue(newValue);
    }
}
