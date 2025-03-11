package com.yono_yuno.backend.domain.cart.bean;

import com.yono_yuno.backend.domain.cart.bean.small.CreateResponseGetCartDTOBean;
import com.yono_yuno.backend.domain.cart.bean.small.GetCartEntityBean;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseGetCartDTO;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetCartBean {
    //카트 정보 조회
    //카트 정보 보내기
    private final GetCartEntityBean getCartEntityBean;
    private final CreateResponseGetCartDTOBean createResponseGetCartDTOBean;

    public GetCartBean (GetCartEntityBean getCartEntityBean, CreateResponseGetCartDTOBean createResponseGetCartDTOBean){
        this.getCartEntityBean=getCartEntityBean;
        this.createResponseGetCartDTOBean=createResponseGetCartDTOBean;
    }

    public ResponseGetCartDTO exec(UUID cartId){
        CartEntity cart = getCartEntityBean.exec(cartId);

        if (cart == null){
            throw new CustomException(ErrorCode.CART_NOT_FOUND);
        }
        return createResponseGetCartDTOBean.exec(cart);

    }
}
