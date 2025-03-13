package com.yono_yuno.backend.domain.account.service;

import com.yono_yuno.backend.domain.account.bean.GetAccountBean;
import com.yono_yuno.backend.domain.account.bean.UpdateAccountBean;
import com.yono_yuno.backend.domain.account.entity.dto.RequestUpdateAccountDTO;
import com.yono_yuno.backend.domain.account.entity.dto.ResponseGetAccountDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {
    private final GetAccountBean getAccountBean;
    private final UpdateAccountBean updateAccountBean;

    public AccountService(GetAccountBean getAccountBean,UpdateAccountBean updateAccountBean) {
        this.getAccountBean = getAccountBean;
        this.updateAccountBean = updateAccountBean;
    }

    public ResponseGetAccountDTO getAccount(UUID userId) {
        return getAccountBean.exec(userId);
    }

    public boolean updateBalance(RequestUpdateAccountDTO requestUpdateAccountDTO){
        return updateAccountBean.exec(requestUpdateAccountDTO);
    }


}
