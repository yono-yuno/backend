package com.yono_yuno.backend.domain.cart.service;

import com.yono_yuno.backend.domain.cart.bean.CreateCartBean;
import com.yono_yuno.backend.domain.cart.bean.GetCartBean;
import com.yono_yuno.backend.domain.cart.bean.UpdateCartBean;
import com.yono_yuno.backend.domain.cart.entity.dto.RequestCreateCartDTO;
import com.yono_yuno.backend.domain.cart.entity.dto.RequestUpdateCartDTO;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseCreateCartDTO;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseGetCartDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartService {
    private final CreateCartBean createCartBean;
    private final GetCartBean getCartBean;
    private final UpdateCartBean updateCartBean;

    public CartService(CreateCartBean createCartBean,GetCartBean getCartBean, UpdateCartBean updateCartBean){
        this.createCartBean=createCartBean;
        this.getCartBean=getCartBean;
        this.updateCartBean=updateCartBean;
    }

    public ResponseCreateCartDTO cartIn(RequestCreateCartDTO requestCreateCartDTO){
        return createCartBean.exec(requestCreateCartDTO);
    }
    public ResponseGetCartDTO getCart(UUID cartId){
        return getCartBean.exec(cartId);
    }
    public boolean updateCart(RequestUpdateCartDTO requestUpdateCartDTO){
        return updateCartBean.exec(requestUpdateCartDTO);

    }
}
