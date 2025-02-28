package com.yono_yuno.backend.domain.user.service;

import com.yono_yuno.backend.domain.user.bean.CreateUserBean;
import com.yono_yuno.backend.domain.user.bean.GetUserBean;
import com.yono_yuno.backend.domain.user.bean.UpdateUserBean;
import com.yono_yuno.backend.domain.user.entity.dto.*;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final CreateUserBean createUserBean;
    private final GetUserBean getUserBean;
    private final UpdateUserBean updateUserBean;

    public UserService(CreateUserBean createUserBean, GetUserBean getUserBean, UpdateUserBean updateUserBean) {
        this.createUserBean = createUserBean;
        this.getUserBean = getUserBean;
        this.updateUserBean = updateUserBean;
    }

    public boolean signUp(RequestSignUpDTO requestSignUpDTO) {
        return createUserBean.exec(requestSignUpDTO);
    }

    public ResponseLoginDTO login(RequestLoginDTO requestLoginDTO) {
        return getUserBean.exec(requestLoginDTO);
    }

    public boolean updateSetting(RequestUpdateSettingDTO requestUpdateSettingDTO) {
        return updateUserBean.exec(requestUpdateSettingDTO);
    }

    public ResponseGetUserDTO getUser(UUID userId) {
        return getUserBean.exec(userId);
    }
}
