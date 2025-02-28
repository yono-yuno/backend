package com.yono_yuno.backend.domain.user.bean;

import com.yono_yuno.backend.domain.user.bean.small.CreateResponseGetUserDTOBean;
import com.yono_yuno.backend.domain.user.bean.small.CreateResponseLoginDTOBean;
import com.yono_yuno.backend.domain.user.bean.small.GetUserEntityBean;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.domain.user.entity.dto.RequestLoginDTO;
import com.yono_yuno.backend.domain.user.entity.dto.ResponseGetUserDTO;
import com.yono_yuno.backend.domain.user.entity.dto.ResponseLoginDTO;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetUserBean {
    private final GetUserEntityBean getUserEntityBean;
    private final CreateResponseLoginDTOBean createResponseLoginDTOBean;
    private final CreateResponseGetUserDTOBean createResponseGetUserDTOBean;

    public GetUserBean(GetUserEntityBean getUserEntityBean, CreateResponseLoginDTOBean createResponseLoginDTOBean, CreateResponseGetUserDTOBean createResponseGetUserDTOBean) {
        this.getUserEntityBean = getUserEntityBean;
        this.createResponseLoginDTOBean = createResponseLoginDTOBean;
        this.createResponseGetUserDTOBean = createResponseGetUserDTOBean;
    }

    public ResponseLoginDTO exec(RequestLoginDTO requestLoginDTO) {
        UserEntity user = getUserEntityBean.exec(requestLoginDTO.getPhoneNum(), requestLoginDTO.getPassWord());

        if (user == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        return createResponseLoginDTOBean.exec(user);
    }

    public ResponseGetUserDTO exec(UUID userId) {
        UserEntity user = getUserEntityBean.exec(userId);

        if (user == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        return createResponseGetUserDTOBean.exec(user);
    }
}
