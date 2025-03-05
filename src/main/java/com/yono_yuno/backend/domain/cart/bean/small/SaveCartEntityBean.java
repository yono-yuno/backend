package com.yono_yuno.backend.domain.cart.bean.small;

import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.repository.CartRepositoryJpa;
import org.springframework.stereotype.Component;

@Component
public class SaveCartEntityBean {
    private final CartRepositoryJpa cartRepositoryJpa;

    public SaveCartEntityBean (CartRepositoryJpa cartRepositoryJpa){
        this.cartRepositoryJpa=cartRepositoryJpa;
    }
    public void exec(CartEntity cartEntity){
        cartRepositoryJpa.save(cartEntity);
    }
}
