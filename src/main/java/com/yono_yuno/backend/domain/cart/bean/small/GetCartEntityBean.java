package com.yono_yuno.backend.domain.cart.bean.small;

import com.yono_yuno.backend.domain.cart.bean.GetCartBean;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.repository.CartRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetCartEntityBean {
    private final CartRepositoryJpa cartRepositoryJpa;

    public GetCartEntityBean(CartRepositoryJpa cartRepositoryJpa){
        this.cartRepositoryJpa=cartRepositoryJpa;
    }

    public CartEntity  exec(UUID cartId){
        return cartRepositoryJpa.findById(cartId).orElse(null);
    }
}
