package com.yono_yuno.backend.domain.cart.service;

import com.yono_yuno.backend.domain.cart.bean.CreateCartBean;
import com.yono_yuno.backend.domain.cart.bean.GetAllCartBean;
import com.yono_yuno.backend.domain.cart.bean.GetCartBean;
import com.yono_yuno.backend.domain.cart.bean.UpdateCartBean;
import com.yono_yuno.backend.domain.cart.entity.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartService {
    private final CreateCartBean createCartBean;
    private final GetCartBean getCartBean;
    private final UpdateCartBean updateCartBean;
    private final GetAllCartBean getAllCartBean;

    public CartService(CreateCartBean createCartBean,GetCartBean getCartBean, UpdateCartBean updateCartBean, GetAllCartBean getAllCartBean){
        this.createCartBean=createCartBean;
        this.getCartBean=getCartBean;
        this.updateCartBean=updateCartBean;
        this.getAllCartBean=getAllCartBean;
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
    public List<ResponseGetAllCartDTO> getAllCart(UUID userId, String sort){
        return getAllCartBean.exec(userId, sort);
    }
}
