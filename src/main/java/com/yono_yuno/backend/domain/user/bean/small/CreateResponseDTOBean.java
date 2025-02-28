package com.yono_yuno.backend.domain.user.bean.small;

import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.domain.user.entity.dto.ResponseLoginDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateResponseDTOBean {
    public ResponseLoginDTO exec(UserEntity user) {
        return ResponseLoginDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .build();
    }
}
