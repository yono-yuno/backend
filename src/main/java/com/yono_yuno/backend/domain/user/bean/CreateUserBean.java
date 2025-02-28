package com.yono_yuno.backend.domain.user.bean;

import com.yono_yuno.backend.domain.account.bean.CreateAccountBean;
import com.yono_yuno.backend.domain.user.bean.small.CreateUserEntityBean;
import com.yono_yuno.backend.domain.user.bean.small.GetUserEntityBean;
import com.yono_yuno.backend.domain.user.bean.small.SaveUserEntityBean;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.domain.user.entity.dto.RequestSignUpDTO;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class CreateUserBean {
    private final GetUserEntityBean getUserEntityBean;
    private final CreateUserEntityBean createUserEntityBean;
    private final SaveUserEntityBean saveUserEntityBean;
    private final CreateAccountBean createAccountBean;

    public CreateUserBean(GetUserEntityBean getUserEntityBean, CreateUserEntityBean createUserEntityBean, SaveUserEntityBean saveUserEntityBean, CreateAccountBean createAccountBean) {
        this.getUserEntityBean = getUserEntityBean;
        this.createUserEntityBean = createUserEntityBean;
        this.saveUserEntityBean = saveUserEntityBean;
        this.createAccountBean = createAccountBean;
    }

    public boolean exec(RequestSignUpDTO requestSignUpDTO) {
        // 이미 전화번호로 회원가입한 유저가 존재할 경우
        if (getUserEntityBean.exec(requestSignUpDTO.getPhoneNum()) != null) {
            throw new CustomException(ErrorCode.USER_IS_EXIST);
        }

        UserEntity user = createUserEntityBean.exec(requestSignUpDTO);

        saveUserEntityBean.exec(user);

        // account 객체가 성공적으로 처리가 됐을 경우 true 반환
        return createAccountBean.exec(user, requestSignUpDTO.getAccountNum());
    }
}
