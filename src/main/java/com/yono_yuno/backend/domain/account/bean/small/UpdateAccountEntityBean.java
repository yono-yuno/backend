package com.yono_yuno.backend.domain.account.bean.small;

import com.yono_yuno.backend.domain.account.entity.AccountEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateAccountEntityBean {
    public AccountEntity exec(AccountEntity account, int balance){
        account.setBalance(balance);
        return account;
    }
}
