package com.yono_yuno.backend.domain.account.bean.small;

import com.yono_yuno.backend.domain.account.entity.AccountEntity;
import com.yono_yuno.backend.domain.account.repository.AccountRepositoryJPA;
import org.springframework.stereotype.Component;

@Component
public class SaveAccountEntityBean {
    private final AccountRepositoryJPA accountRepositoryJPA;

    public SaveAccountEntityBean(AccountRepositoryJPA accountRepositoryJPA) {
        this.accountRepositoryJPA = accountRepositoryJPA;
    }

    public void exec(AccountEntity account) {
        accountRepositoryJPA.save(account);
    }
}
