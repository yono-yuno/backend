package com.yono_yuno.backend.domain.account.bean;

import com.yono_yuno.backend.domain.account.bean.small.GetAccountEntityBean;
import com.yono_yuno.backend.domain.account.bean.small.SaveAccountEntityBean;
import com.yono_yuno.backend.domain.account.bean.small.UpdateAccountEntityBean;
import com.yono_yuno.backend.domain.account.entity.AccountEntity;
import com.yono_yuno.backend.domain.account.entity.dto.RequestUpdateAccountDTO;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class UpdateAccountBean {
    //계좌 조회
    //계죄 수정
    //계좌 저장
    private final GetAccountEntityBean getAccountEntityBean;
    private final UpdateAccountEntityBean updateAccountEntityBean;
    private final SaveAccountEntityBean saveAccountEntityBean;
    public UpdateAccountBean(GetAccountEntityBean getAccountEntityBean,UpdateAccountEntityBean updateAccountEntityBean,SaveAccountEntityBean saveAccountEntityBean) {
        this.getAccountEntityBean=getAccountEntityBean;
        this.updateAccountEntityBean=updateAccountEntityBean;
        this.saveAccountEntityBean=saveAccountEntityBean;
    }

    public boolean exec(RequestUpdateAccountDTO requestUpdateAccountDTO){
        AccountEntity account=getAccountEntityBean.exec(requestUpdateAccountDTO.getAccountId());
        if(account ==null){
            throw  new CustomException(ErrorCode.ACCOUNT_NOT_FOUND);
        }
        AccountEntity accountupdate=updateAccountEntityBean.exec(account,requestUpdateAccountDTO.getBalance());

        if(accountupdate == null){
            return false;
        }
        saveAccountEntityBean.exec(accountupdate);
        return true;
    }

}
