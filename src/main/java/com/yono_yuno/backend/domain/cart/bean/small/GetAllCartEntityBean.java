package com.yono_yuno.backend.domain.cart.bean.small;

import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.repository.CartRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@Component
public class GetAllCartEntityBean {
    private final CartRepositoryJPA cartRepositoryJpa;

    public GetAllCartEntityBean (CartRepositoryJPA cartRepositoryJpa){
        this.cartRepositoryJpa=cartRepositoryJpa;
    }
    public List<CartEntity>exec(UUID userId){
        return cartRepositoryJpa.findAllByUserId(userId);
    }
}
