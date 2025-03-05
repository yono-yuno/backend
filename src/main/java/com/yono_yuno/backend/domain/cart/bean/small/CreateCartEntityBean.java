package com.yono_yuno.backend.domain.cart.bean.small;

import com.yono_yuno.backend.domain.cart.entity.AskCount;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.entity.dto.RequestCreateCartDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateCartEntityBean {
    public CartEntity exec(RequestCreateCartDTO requestCreateCartDTO){
        return CartEntity.builder()
                .cartId(UUID.randomUUID())
                .userId(requestCreateCartDTO.getUserId())
                .itemId(requestCreateCartDTO.getItemId())
                .askCount(AskCount.FIRST_THINK.ordinal())
                .build();
    }
}
