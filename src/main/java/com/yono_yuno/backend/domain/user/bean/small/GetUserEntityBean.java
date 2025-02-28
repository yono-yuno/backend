package com.yono_yuno.backend.domain.user.bean.small;

import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.domain.user.repository.UserRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetUserEntityBean {
    private final UserRepositoryJPA userRepositoryJPA;

    public GetUserEntityBean(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    public UserEntity exec(String phoneNum) {
        return userRepositoryJPA.findByPhoneNum(phoneNum);
    }

    public UserEntity exec(String phoneNum, String passWord) {
        return userRepositoryJPA.findByPhoneNumAndPassWord(phoneNum, passWord);
    }

    public UserEntity exec(UUID userId) {
        return  userRepositoryJPA.findById(userId).orElse(null);
    }
}
