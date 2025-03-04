package com.yono_yuno.backend.domain.user.bean.small;

import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.domain.user.repository.UserRepositoryJPA;
import org.springframework.stereotype.Component;

@Component
public class SaveUserEntityBean {
    private final UserRepositoryJPA userRepositoryJPA;

    public SaveUserEntityBean(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    public void exec(UserEntity user) {
        userRepositoryJPA.save(user);
    }
}
