package com.yono_yuno.backend.domain.cart.bean.small;

import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.repository.CartRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetCartEntityBean {
    private final CartRepositoryJPA cartRepositoryJpa;

    public GetCartEntityBean(CartRepositoryJPA cartRepositoryJpa){
        this.cartRepositoryJpa=cartRepositoryJpa;
    }

    public CartEntity  exec(UUID cartId){
        return cartRepositoryJpa.findById(cartId).orElse(null);
    }
}
