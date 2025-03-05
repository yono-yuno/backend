package com.yono_yuno.backend.domain.cart.bean.small;

import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseGetCartDTO;
import com.yono_yuno.backend.domain.cart.entity.dto.GetItemInfo;
import org.springframework.stereotype.Component;

@Component
public class CreateResponseGetCartDTOBean {
    public ResponseGetCartDTO exec(CartEntity cartEntity){
       return ResponseGetCartDTO.builder()
                .itemInfo(GetItemInfo.builder().build())
                .askCount(cartEntity.getAskCount())
                .build();
    }
}
