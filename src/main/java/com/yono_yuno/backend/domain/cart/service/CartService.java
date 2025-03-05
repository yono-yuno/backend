package com.yono_yuno.backend.domain.cart.service;

import com.yono_yuno.backend.domain.cart.bean.CreateCartBean;
import com.yono_yuno.backend.domain.cart.entity.dto.RequestCreateCartDTO;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseCreateCartDTO;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CreateCartBean createCartBean;

    public CartService(CreateCartBean createCartBean){
        this.createCartBean=createCartBean;
    }

    public ResponseCreateCartDTO cartIn(RequestCreateCartDTO requestCreateCartDTO){
        return createCartBean.exec(requestCreateCartDTO);
    }
}
