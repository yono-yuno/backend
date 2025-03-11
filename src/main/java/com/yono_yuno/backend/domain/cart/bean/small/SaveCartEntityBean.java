package com.yono_yuno.backend.domain.cart.bean.small;

import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.repository.CartRepositoryJPA;
import org.springframework.stereotype.Component;

@Component
public class SaveCartEntityBean {
    private final CartRepositoryJPA cartRepositoryJpa;

    public SaveCartEntityBean (CartRepositoryJPA cartRepositoryJpa){
        this.cartRepositoryJpa=cartRepositoryJpa;
    }
    public void exec(CartEntity cartEntity){
        cartRepositoryJpa.save(cartEntity);
    }
}
