package com.yono_yuno.backend.domain.account.service;

import com.yono_yuno.backend.domain.account.bean.GetAccountBean;
import com.yono_yuno.backend.domain.account.entity.dto.ResponseGetAccountDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {
    private final GetAccountBean getAccountBean;

    public AccountService(GetAccountBean getAccountBean) {
        this.getAccountBean = getAccountBean;
    }

    public ResponseGetAccountDTO getAccount(UUID AccountId) {
        return getAccountBean.exec(AccountId);
    }


}
