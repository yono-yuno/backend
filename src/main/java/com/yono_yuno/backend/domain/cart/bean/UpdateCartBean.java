package com.yono_yuno.backend.domain.cart.bean;

import com.yono_yuno.backend.domain.cart.bean.small.GetCartEntityBean;
import com.yono_yuno.backend.domain.cart.bean.small.SaveCartEntityBean;
import com.yono_yuno.backend.domain.cart.bean.small.UpdateCartEntityBean;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.entity.dto.RequestUpdateCartDTO;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class UpdateCartBean {
    //카트 정보 조회
    //카트 정보 수정
    //카트 정보 저장
    private final GetCartEntityBean getCartEntityBean;
    private final UpdateCartEntityBean updateCartEntityBean;
    private final SaveCartEntityBean saveCartEntityBean;

    public UpdateCartBean(GetCartEntityBean getCartEntityBean, UpdateCartEntityBean updateCartEntityBean, SaveCartEntityBean saveCartEntityBean){
        this.getCartEntityBean=getCartEntityBean;
        this.updateCartEntityBean=updateCartEntityBean;
        this.saveCartEntityBean=saveCartEntityBean;
    }
    public boolean exec(RequestUpdateCartDTO requestUpdateCartDTO){
        CartEntity cart=getCartEntityBean.exec(requestUpdateCartDTO.getCartId());

        if(cart ==null){
            throw new CustomException(ErrorCode.CART_NOT_FOUND);
        }

        CartEntity update=updateCartEntityBean.exec(cart, requestUpdateCartDTO.getAskCount());

        if(update ==null){
            return false;
        }
        saveCartEntityBean.exec(cart);
        return true;
    }
}
