package com.yono_yuno.backend.domain.cart.bean.small;

import com.yono_yuno.backend.domain.cart.entity.AskCount;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.repository.CartRepositoryJpa;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.domain.user.repository.UserRepositoryJPA;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Component
public class CaculationExtraTime {
    private final UserRepositoryJPA userRepositoryJPA;
    private final CartRepositoryJpa cartRepositoryJpa;

    public CaculationExtraTime(UserRepositoryJPA userRepositoryJPA, CartRepositoryJpa cartRepositoryJpa) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.cartRepositoryJpa = cartRepositoryJpa;
    }

    public String extraTime(UUID userId, UUID cartId) {
        // User 정보 가져오기
        UserEntity user = getUser(userId);
        // User의 설정 시간 가져오기
        String userTime = getUserTime(user);

        // User 시간 처리
        int days = Integer.parseInt(userTime.substring(0, 2));
        int hours = Integer.parseInt(userTime.substring(2, 4));
        int totalMinutes = (days * 24 * 60) + (hours * 60); // userTime을 분 단위로 변환
        long halfTimeInMinutes = totalMinutes / 2;

        // Cart 정보 가져오기
        CartEntity cart = getCart(cartId);

        // Cart 시간 처리
        LocalDateTime cartTime = getCartTime(cart);

        // 시간을 더한 결과 계산
        LocalDateTime extraDateTime = cartTime.plusMinutes(halfTimeInMinutes);

        // 차이 계산 (일, 시간, 분)
        long extraDays = ChronoUnit.DAYS.between(cartTime, extraDateTime);
        long extraHours = ChronoUnit.HOURS.between(cartTime, extraDateTime) % 24;
        long extraMinutes = ChronoUnit.MINUTES.between(cartTime, extraDateTime) % 60;

        return String.format("%02d%02d%02d", extraDays, extraHours, extraMinutes);
    }

    // User 정보 가져오기
    private UserEntity getUser(UUID userId) {
        UserEntity user = userRepositoryJPA.findById(userId).orElse(null);
        if (user == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }
        return user;
    }

    // User의 설정 시간 가져오기
    private String getUserTime(UserEntity user) {
        return user.getSettingTime();
    }

    // Cart 정보 가져오기
    private CartEntity getCart(UUID cartId) {
        CartEntity cart = cartRepositoryJpa.findById(cartId).orElse(null);
        if (cart == null) {
            throw new CustomException(ErrorCode.CART_NOT_FOUND);
        }
        return cart;
    }

    // Cart의 시간 가져오기
    private LocalDateTime getCartTime(CartEntity cart) {
        AskCount askCount = cart.getAskCount();
        LocalDateTime cartTime = null;

        if (askCount == AskCount.FIRST_THINK) {
            cartTime = cart.getCreatedAt();
        } else if (askCount == AskCount.SECOND_THINK) {
            cartTime = cart.getUpdatedAt();
        }

        if (cartTime == null) {
            throw new CustomException(ErrorCode.CART_TIME_NOT_FOUND);
        }

        return cartTime;
    }
}
