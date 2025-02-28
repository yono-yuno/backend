package com.yono_yuno.backend.domain.user.service;

import com.yono_yuno.backend.domain.user.bean.CreateUserBean;
import com.yono_yuno.backend.domain.user.entity.dto.RequestSignUpDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final CreateUserBean createUserBean;

    public UserService(CreateUserBean createUserBean) {
        this.createUserBean = createUserBean;
    }

    public Boolean signUp(RequestSignUpDTO requestSignUpDTO) {
        return createUserBean.exec(requestSignUpDTO);
    }
}
