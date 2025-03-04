package com.yono_yuno.backend.domain.cart.bean.small;

import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.entity.DTO.ResponseCreateCartDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateCartDtoBean {
    public ResponseCreateCartDTO exec(CartEntity cartEntity){
        return ResponseCreateCartDTO.builder()
                .diaryId(cartEntity.getCartId())
                .userId(cartEntity.getUserId())
                .itemId(cartEntity.getItemId())
                .askCount(cartEntity.getAskCount())
                .build();
    }
}
