package com.yono_yuno.backend.domain.cart.bean.small;

import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseGetAllCartDTO;
import com.yono_yuno.backend.domain.item.bean.small.CreateItemInfoDTOBean;
import com.yono_yuno.backend.domain.item.bean.small.GetItemEntityBean;
import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import com.yono_yuno.backend.domain.item.entity.dto.ItemInfoDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateResponseGetAllCartDTOBean {
    private final CalculationExtraTime calculationExtraTime;
    private final GetItemEntityBean getItemEntityBean;
    private final CreateItemInfoDTOBean createItemInfoDTOBean;

    public CreateResponseGetAllCartDTOBean(CalculationExtraTime calculationExtraTime, GetItemEntityBean getItemEntityBean, CreateItemInfoDTOBean createItemInfoDTOBean) {
        this.calculationExtraTime = calculationExtraTime;
        this.getItemEntityBean = getItemEntityBean;
        this.createItemInfoDTOBean = createItemInfoDTOBean;
    }

    public ResponseGetAllCartDTO exec(CartEntity cart) {
        String extraTime = calculationExtraTime.exec(cart.getUserId(), cart);
        ItemEntity item = getItemEntityBean.exec(cart.getItemId());
        ItemInfoDTO itemInfoDTO = createItemInfoDTOBean.exec(item);

        return ResponseGetAllCartDTO.builder()
                .cartId(cart.getCartId())
                .userId(cart.getUserId())
                .askCount(cart.getAskCount())
                .extraTime(extraTime)
                .createdAt(cart.getCreatedAt())
                .itemInfo(itemInfoDTO)
                .build();
    }
}
