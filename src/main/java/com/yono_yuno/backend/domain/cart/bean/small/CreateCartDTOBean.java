package com.yono_yuno.backend.domain.cart.bean.small;

import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseCreateCartDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateCartDTOBean {
    public ResponseCreateCartDTO exec(CartEntity cartEntity){
        return ResponseCreateCartDTO.builder()
                .cartId(cartEntity.getCartId())
                .userId(cartEntity.getUserId())
                .itemId(cartEntity.getItemId())
                .createAt(cartEntity.getCreatedAt())
                .askCount(cartEntity.getAskCount())
                .build();
    }
}
