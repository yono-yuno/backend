package com.yono_yuno.backend.domain.user.bean.small;

import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.domain.user.entity.dto.ResponseGetUserDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateResponseGetUserDTOBean {
    public ResponseGetUserDTO exec(UserEntity user) {
        return ResponseGetUserDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .phoneNum(user.getPhoneNum())
                .overPrice(user.getOverPrice())
                .settingTime(user.getSettingTime())
                .build();
    }
}
