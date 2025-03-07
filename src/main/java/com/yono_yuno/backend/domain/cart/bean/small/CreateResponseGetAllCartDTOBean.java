package com.yono_yuno.backend.domain.cart.bean.small;

import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseGetAllCartDTO;
import com.yono_yuno.backend.domain.cart.entity.dto.GetItemInfo;
import org.springframework.stereotype.Component;

@Component
public class CreateResponseGetAllCartDTOBean {
    private final CalculationExtraTime calculationExtraTime;

    public CreateResponseGetAllCartDTOBean(CalculationExtraTime calculationExtraTime){
        this.calculationExtraTime = calculationExtraTime;
    }
    public ResponseGetAllCartDTO exec(CartEntity cart){
        String extraTime = calculationExtraTime.extraTime(cart.getUserId(), cart);

        return ResponseGetAllCartDTO.builder()
                .cartId(cart.getCartId())
                .userId(cart.getUserId())
                .askCount(cart.getAskCount())
                .extraTime(extraTime)
                .createdAt(cart.getCreatedAt())
                .itemInfo(GetItemInfo.builder().build())
                .build();
    }
}
