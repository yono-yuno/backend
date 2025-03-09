package com.yono_yuno.backend.domain.account.bean;

import com.yono_yuno.backend.domain.account.bean.small.CreateResponseGetAccountDTOBean;
import com.yono_yuno.backend.domain.account.bean.small.GetAccountEntityBean;
import com.yono_yuno.backend.domain.account.entity.AccountEntity;
import com.yono_yuno.backend.domain.account.entity.dto.ResponseGetAccountDTO;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class GetAccountBean {
    private final GetAccountEntityBean getAccountEntityBean;
    private final CreateResponseGetAccountDTOBean createResponseGetAccountDTOBean;


    @Autowired
    public GetAccountBean(GetAccountEntityBean getAccountEntityBean, CreateResponseGetAccountDTOBean createResponseGetAccountDTOBean) {
        this.getAccountEntityBean = getAccountEntityBean;
        this.createResponseGetAccountDTOBean = createResponseGetAccountDTOBean;
    }

    public ResponseGetAccountDTO exec(UUID accountId) {
        AccountEntity account = getAccountEntityBean.exec(accountId);

        if (account == null) {
            throw new CustomException(ErrorCode.ACCOUNT_NOT_FOUND);
        }

        return createResponseGetAccountDTOBean.exec(account);
    }
}
