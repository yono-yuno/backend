package com.yono_yuno.backend.domain.account.bean.small;

import com.yono_yuno.backend.domain.account.entity.AccountEntity;
import com.yono_yuno.backend.domain.account.entity.dto.ResponseGetAccountDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateResponseGetAccountDTOBean {
    public ResponseGetAccountDTO exec(AccountEntity account) {
        return ResponseGetAccountDTO.builder()
                .accountId(account.getAccountId())
                .accountNum(account.getAccountNum())
                .balance(account.getBalance())
                .build();
    }
}
