package com.yono_yuno.backend.domain.cart.bean;

import com.yono_yuno.backend.domain.cart.bean.small.CreateCartDTOBean;
import com.yono_yuno.backend.domain.cart.bean.small.CreateCartEntityBean;
import com.yono_yuno.backend.domain.cart.bean.small.SaveCartEntityBean;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.entity.dto.RequestCreateCartDTO;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseCreateCartDTO;
import com.yono_yuno.backend.domain.item.bean.small.GetItemEntityBean;
import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import com.yono_yuno.backend.domain.user.bean.small.GetUserEntityBean;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class CreateCartBean {
    private final GetUserEntityBean getUserEntityBean;
    private final GetItemEntityBean getItemEntityBean;
    private final CreateCartEntityBean createCartEntityBean;
    private final SaveCartEntityBean saveCartEntityBean;
    private final CreateCartDTOBean createCartDtoBean;

    public CreateCartBean(GetUserEntityBean getUserEntityBean, GetItemEntityBean getItemEntityBean, CreateCartEntityBean createCartEntityBean,SaveCartEntityBean saveCartEntityBean, CreateCartDTOBean createCartDtoBean){
        this.getUserEntityBean = getUserEntityBean;
        this.getItemEntityBean = getItemEntityBean;
        this.createCartEntityBean=createCartEntityBean;
        this.saveCartEntityBean=saveCartEntityBean;
        this.createCartDtoBean = createCartDtoBean;
    }

    public ResponseCreateCartDTO exec(RequestCreateCartDTO requestCreateCartDTO) {
        UserEntity user = getUserEntityBean.exec(requestCreateCartDTO.getUserId());
        if (user == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        ItemEntity item = getItemEntityBean.exec(requestCreateCartDTO.getItemId());
        if (item == null) {
            throw new CustomException(ErrorCode.ITEM_NOT_FOUND);
        }

        CartEntity cartEntity = createCartEntityBean.exec(requestCreateCartDTO);

        if (cartEntity == null) {
            throw new CustomException(ErrorCode.CART_NOT_IN);
        }

        saveCartEntityBean.exec(cartEntity);
        return createCartDtoBean.exec(cartEntity);
    }
}
