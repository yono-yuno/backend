package com.yono_yuno.backend.domain.user.bean.small;

import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.domain.user.entity.dto.RequestSignUpDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserEntityBean {
    public UserEntity exec(RequestSignUpDTO requestSignUpDTO) {
        return UserEntity.builder()
                .userId(UUID.randomUUID())
                .userName(requestSignUpDTO.getUserName())
                .phoneNum(requestSignUpDTO.getPhoneNum())
                .passWord(requestSignUpDTO.getPassWord())
                .build();
    }
}
