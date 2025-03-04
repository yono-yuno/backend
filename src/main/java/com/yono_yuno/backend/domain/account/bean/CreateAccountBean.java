package com.yono_yuno.backend.domain.account.bean;

import com.yono_yuno.backend.domain.account.bean.small.CreateAccountEntityBean;
import com.yono_yuno.backend.domain.account.bean.small.SaveAccountEntityBean;
import com.yono_yuno.backend.domain.account.entity.AccountEntity;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class CreateAccountBean {
    private final CreateAccountEntityBean createAccountEntityBean;
    private final SaveAccountEntityBean saveAccountEntityBean;

    public CreateAccountBean(CreateAccountEntityBean createAccountEntityBean, SaveAccountEntityBean saveAccountEntityBean) {
        this.createAccountEntityBean = createAccountEntityBean;
        this.saveAccountEntityBean = saveAccountEntityBean;
    }

    public boolean exec(UserEntity user, String accountNum) {
        AccountEntity account = createAccountEntityBean.exec(user, accountNum);

        // account 객체가 생성되지 않았을 경우
        if (account == null) {
            throw new CustomException(ErrorCode.ACCOUNT_NOT_FOUND);
        }

        saveAccountEntityBean.exec(account);

        // 저장까지 성공했을 경우 true 반환
        return true;
    }
}
