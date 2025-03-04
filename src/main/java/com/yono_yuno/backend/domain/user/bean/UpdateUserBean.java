package com.yono_yuno.backend.domain.user.bean;

import com.yono_yuno.backend.domain.user.bean.small.GetUserEntityBean;
import com.yono_yuno.backend.domain.user.bean.small.SaveUserEntityBean;
import com.yono_yuno.backend.domain.user.bean.small.UpdateUserEntityBean;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.domain.user.entity.dto.RequestUpdateSettingDTO;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserBean {
    private final GetUserEntityBean getUserEntityBean;
    private final UpdateUserEntityBean updateUserEntityBean;
    private final SaveUserEntityBean saveUserEntityBean;

    public UpdateUserBean(GetUserEntityBean getUserEntityBean, UpdateUserEntityBean updateUserEntityBean, SaveUserEntityBean saveUserEntityBean) {
        this.getUserEntityBean = getUserEntityBean;
        this.updateUserEntityBean = updateUserEntityBean;
        this.saveUserEntityBean = saveUserEntityBean;
    }

    public boolean exec(RequestUpdateSettingDTO requestUpdateSettingDTO) {
        UserEntity user = getUserEntityBean.exec(requestUpdateSettingDTO.getUserId());

        // userId로 조회했을 때 유저가 존재하지 않을 경우
        if (user == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        UserEntity updateUser = updateUserEntityBean.exec(user, requestUpdateSettingDTO.getOverPrice(), requestUpdateSettingDTO.getSettingTime());

        // 업데이트한 유저 객체가 null일 경우
        if (updateUser == null) {
            return false;
        }

        saveUserEntityBean.exec(updateUser);

        return true;
    }
}
