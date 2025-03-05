package com.yono_yuno.backend.domain.cart.service;

import com.yono_yuno.backend.domain.cart.bean.CreateCartBean;
import com.yono_yuno.backend.domain.cart.bean.GetCartBean;
import com.yono_yuno.backend.domain.cart.entity.dto.RequestCreateCartDTO;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseCreateCartDTO;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseGetCartDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartService {
    private final CreateCartBean createCartBean;
    private final GetCartBean getCartBean;

    public CartService(CreateCartBean createCartBean,GetCartBean getCartBean){
        this.createCartBean=createCartBean;
        this.getCartBean=getCartBean;
    }

    public ResponseCreateCartDTO cartIn(RequestCreateCartDTO requestCreateCartDTO){
        return createCartBean.exec(requestCreateCartDTO);
    }
    public ResponseGetCartDTO getCart(UUID cartId){
        return getCartBean.exec(cartId);
    }
}
