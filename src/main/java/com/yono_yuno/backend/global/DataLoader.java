package com.yono_yuno.backend.global;

import com.yono_yuno.backend.domain.alarm.entity.AlarmEntity;
import com.yono_yuno.backend.domain.alarm.repository.AlarmRepositoryJPA;
import com.yono_yuno.backend.domain.cart.entity.AskCount;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.repository.CartRepositoryJPA;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.repository.DiaryRepositoryJPA;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.domain.user.repository.UserRepositoryJPA;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserRepositoryJPA userRepositoryJPA;
    private final DiaryRepositoryJPA diaryRepositoryJPA;
    private final CartRepositoryJPA cartRepositoryJPA;
    private final AlarmRepositoryJPA alarmRepositoryJPA;

    public DataLoader(UserRepositoryJPA userRepositoryJPA, DiaryRepositoryJPA diaryRepositoryJPA, CartRepositoryJPA cartRepositoryJPA, AlarmRepositoryJPA alarmRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.diaryRepositoryJPA = diaryRepositoryJPA;
        this.cartRepositoryJPA = cartRepositoryJPA;
        this.alarmRepositoryJPA = alarmRepositoryJPA;
    }

    @Override
    public void run(String... args) throws Exception {
        // 기본 데이터 추가
        UserEntity user = UserEntity.builder()
                .userId(UUID.randomUUID())
                .userName("홍길동")
                .phoneNum("01011112222")
                .passWord("123123")
                .overPrice(10000)
                .settingTime("0001")
                .build();

        userRepositoryJPA.save(user);

        DiaryEntity diary1 = DiaryEntity.builder()
                .diaryId(UUID.randomUUID())
                .userId(user.getUserId())
                .firstReview("좋은데요?")
                .consumerStars(4.5)
                .itemId(UUID.randomUUID())
                .build();

        DiaryEntity diary2 = DiaryEntity.builder()
                .diaryId(UUID.randomUUID())
                .userId(user.getUserId())
                .firstReview("나쁜데요?")
                .consumerStars(2.0)
                .itemId(UUID.randomUUID())
                .build();

        diaryRepositoryJPA.save(diary1);
        diaryRepositoryJPA.save(diary2);

        AlarmEntity alarm1 = AlarmEntity.builder()
                .alarmId(UUID.randomUUID())
                .userId(user.getUserId())
                .cartId(null)
                .askCount(null)
                .diaryId(diary2.getDiaryId())
                .isCheck(true)
                .build();

        alarmRepositoryJPA.save(alarm1);

        CartEntity cart1 = CartEntity.builder()
                .cartId(UUID.randomUUID())
                .itemId(UUID.randomUUID())
                .askCount(AskCount.FIRST_THINK)
                .build();

        cartRepositoryJPA.save(cart1);
    }
}
