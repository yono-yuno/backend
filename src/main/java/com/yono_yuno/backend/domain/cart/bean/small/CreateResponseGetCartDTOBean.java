package com.yono_yuno.backend.domain.cart.bean.small;

import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseGetCartDTO;
import com.yono_yuno.backend.domain.item.bean.small.CreateItemInfoDTOBean;
import com.yono_yuno.backend.domain.item.bean.small.GetItemEntityBean;
import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import com.yono_yuno.backend.domain.item.entity.dto.ItemInfoDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateResponseGetCartDTOBean {
    private final GetItemEntityBean getItemEntityBean;
    private final CreateItemInfoDTOBean createItemInfoDTOBean;

    public CreateResponseGetCartDTOBean(GetItemEntityBean getItemEntityBean, CreateItemInfoDTOBean createItemInfoDTOBean) {
        this.getItemEntityBean = getItemEntityBean;
        this.createItemInfoDTOBean = createItemInfoDTOBean;
    }

    public ResponseGetCartDTO exec(CartEntity cartEntity) {
        ItemEntity item = getItemEntityBean.exec(cartEntity.getItemId());
        ItemInfoDTO itemInfoDTO = createItemInfoDTOBean.exec(item);

        return ResponseGetCartDTO.builder()
                .itemInfo(itemInfoDTO)
                .askCount(cartEntity.getAskCount())
                .build();
    }
}
