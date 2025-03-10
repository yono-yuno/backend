package com.yono_yuno.backend.domain.account.bean.small;

import com.yono_yuno.backend.domain.account.entity.AccountEntity;
import com.yono_yuno.backend.domain.account.repository.AccountRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetAccountEntityBean {
    private final AccountRepositoryJPA accountRepositoryJPA;

    public GetAccountEntityBean(AccountRepositoryJPA accountRepositoryJPA) {
        this.accountRepositoryJPA = accountRepositoryJPA;
    }

    public AccountEntity exec(UUID userId) {
        return accountRepositoryJPA.findByUserId(userId);
    }
}
