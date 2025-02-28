package com.yono_yuno.backend.domain.user.bean;

import com.yono_yuno.backend.domain.user.bean.small.CreateResponseDTOBean;
import com.yono_yuno.backend.domain.user.bean.small.GetUserEntityBean;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.domain.user.entity.dto.RequestLoginDTO;
import com.yono_yuno.backend.domain.user.entity.dto.ResponseLoginDTO;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class GetUserBean {
    private final GetUserEntityBean getUserEntityBean;
    private final CreateResponseDTOBean createResponseDTOBean;

    public GetUserBean(GetUserEntityBean getUserEntityBean, CreateResponseDTOBean createResponseDTOBean) {
        this.getUserEntityBean = getUserEntityBean;
        this.createResponseDTOBean = createResponseDTOBean;
    }

    public ResponseLoginDTO exec(RequestLoginDTO requestLoginDTO) {
        UserEntity user = getUserEntityBean.exec(requestLoginDTO.getPhoneNum(), requestLoginDTO.getPassWord());

        if (user == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        return createResponseDTOBean.exec(user);
    }
}
