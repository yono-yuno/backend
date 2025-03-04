package com.yono_yuno.backend.domain.account.bean.small;

import com.yono_yuno.backend.domain.account.entity.AccountEntity;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateAccountEntityBean {
    public AccountEntity exec(UserEntity user, String accountNum) {
        return AccountEntity.builder()
                .accountId(UUID.randomUUID())
                .accountNum(accountNum)
                .userId(user.getUserId())
                .balance(0)
                .build();
    }
}
