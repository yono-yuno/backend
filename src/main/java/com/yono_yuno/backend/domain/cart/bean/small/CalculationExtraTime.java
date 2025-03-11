package com.yono_yuno.backend.domain.cart.bean.small;

import com.yono_yuno.backend.domain.cart.entity.AskCount;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.user.bean.small.GetUserEntityBean;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Component
public class CalculationExtraTime {
    private final GetUserEntityBean getUserEntityBean;

    public CalculationExtraTime(GetUserEntityBean getUserEntityBean) {
        this.getUserEntityBean = getUserEntityBean;
    }

    public String exec(UUID userId, CartEntity cart) {
        UserEntity user = getUserEntityBean.exec(userId);

        // 예외처리
        if (user == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        if (cart == null) {
            throw new CustomException(ErrorCode.CART_NOT_FOUND);
        }

        String userTime= user.getSettingTime();
        if (userTime == null) {
            throw new CustomException(ErrorCode.USER_TIME_NOT_FOUND);
        }

        // User 시간 처리
        int days = Integer.parseInt(userTime.substring(0, 2));
        int hours = Integer.parseInt(userTime.substring(2, 4));
        int totalMinutes = (days * 24 * 60) + (hours * 60); // 유저의 고민시간을 분 단위로 변환
        long halfTimeInMinutes = totalMinutes / 2;

        LocalDateTime cartTime = null;
        AskCount askCount= cart.getAskCount();

        if (askCount == AskCount.FIRST_THINK) {
            cartTime = cart.getCreatedAt();
        } else if (askCount == AskCount.SECOND_THINK) {
            cartTime = cart.getUpdatedAt();
        } else {
            throw new CustomException(ErrorCode.CART_TIME_NOT_FOUND);
        }

        // 시간을 더한 결과 계산
        LocalDateTime extraDateTime = cartTime.plusMinutes(halfTimeInMinutes);

        // 고민시간이 끝났을 경우
        LocalDateTime now = LocalDateTime.now();
        if (extraDateTime.isBefore(now)) {
            return "00-00-00";
        }

        // 차이 계산 (일, 시간, 분)
        long extraDays = ChronoUnit.DAYS.between(now, extraDateTime);
        long extraHours = ChronoUnit.HOURS.between(now, extraDateTime) % 24;
        long extraMinutes = ChronoUnit.MINUTES.between(now, extraDateTime) % 60;

        return String.format("%02d-%02d-%02d", extraDays, extraHours, extraMinutes);
    }
}
