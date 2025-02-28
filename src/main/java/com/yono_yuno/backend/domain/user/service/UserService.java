package com.yono_yuno.backend.domain.user.service;

import com.yono_yuno.backend.domain.user.bean.CreateUserBean;
import com.yono_yuno.backend.domain.user.bean.GetUserBean;
import com.yono_yuno.backend.domain.user.entity.dto.RequestLoginDTO;
import com.yono_yuno.backend.domain.user.entity.dto.RequestSignUpDTO;
import com.yono_yuno.backend.domain.user.entity.dto.ResponseLoginDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final CreateUserBean createUserBean;
    private final GetUserBean getUserBean;

    public UserService(CreateUserBean createUserBean, GetUserBean getUserBean) {
        this.createUserBean = createUserBean;
        this.getUserBean = getUserBean;
    }

    public Boolean signUp(RequestSignUpDTO requestSignUpDTO) {
        return createUserBean.exec(requestSignUpDTO);
    }

    public ResponseLoginDTO login(RequestLoginDTO requestLoginDTO) {
        return getUserBean.exec(requestLoginDTO);
    }
}
