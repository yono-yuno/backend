package com.yono_yuno.backend.domain.user.bean.small;

import com.yono_yuno.backend.domain.user.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserEntityBean {
    public UserEntity exec(UserEntity user, int overPrice, String settingTime) {
        user.setOverPrice(overPrice);
        user.setSettingTime(settingTime);

        return user;
    }
}
