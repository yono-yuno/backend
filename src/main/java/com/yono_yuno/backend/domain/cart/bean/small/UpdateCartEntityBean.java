package com.yono_yuno.backend.domain.cart.bean.small;

import com.yono_yuno.backend.domain.cart.entity.AskCount;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import org.springframework.stereotype.Component;


@Component
public class UpdateCartEntityBean {
    public CartEntity exec(CartEntity cart, AskCount askCount){
        cart.setAskCount(askCount);
        return cart;
    }
}
