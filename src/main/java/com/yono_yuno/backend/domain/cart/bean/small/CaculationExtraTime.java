package com.yono_yuno.backend.domain.cart.bean.small;

import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.repository.CartRepositoryJpa;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.domain.user.repository.UserRepositoryJPA;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;
@Component
public class CaculationExtraTime {
    private final UserRepositoryJPA userRepositoryJPA;
    private final CartRepositoryJpa cartRepositoryJpa;

    public CaculationExtraTime(UserRepositoryJPA userRepositoryJPA, CartRepositoryJpa cartRepositoryJpa) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.cartRepositoryJpa = cartRepositoryJpa;
    }
    public String extraTime(UUID userId, UUID cartId){
        UserEntity user = userRepositoryJPA.findById(userId).orElse(null);
        if (user==null){
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
            //오류 어떻게 설정할지 생각 좀 해보기
        }
        String userTime=user.getSettingTime();

        CartEntity cart=cartRepositoryJpa.findById(cartId).orElse(null);
        if (cart==null){
            throw new CustomException(ErrorCode.CART_NOT_FOUND);
            //오류 어떻게 설정할지 생각 좀 해보기
        }
        LocalDateTime cartTime=cart.getCreatedAt();
        
        String extraTime=//계산 결과 저장
        return extraTime;
    }
}
