package com.yono_yuno.backend.domain.diary.bean;

import com.yono_yuno.backend.domain.diary.bean.small.CreateResponseGetAllDiaryDTOBean;
import com.yono_yuno.backend.domain.diary.bean.small.GetAllDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetAllDiaryDTO;
import com.yono_yuno.backend.domain.user.bean.small.GetUserEntityBean;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class GetAllDiaryBean {
    private final GetUserEntityBean getUserEntityBean;
    private final GetAllDiaryEntityBean getAllDiaryEntityBean;
    private final CreateResponseGetAllDiaryDTOBean createResponseGetAllDiaryDTOBean;

    public GetAllDiaryBean(GetUserEntityBean getUserEntityBean, GetAllDiaryEntityBean getAllDiaryEntityBean, CreateResponseGetAllDiaryDTOBean createResponseGetAllDiaryDTOBean) {
        this.getUserEntityBean = getUserEntityBean;
        this.getAllDiaryEntityBean=getAllDiaryEntityBean;
        this.createResponseGetAllDiaryDTOBean=createResponseGetAllDiaryDTOBean;
    }

    public List<ResponseGetAllDiaryDTO> exec(UUID userId) {
        UserEntity user = getUserEntityBean.exec(userId);
        if (user == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        List<DiaryEntity> diaryEntityList = getAllDiaryEntityBean.exec(userId);

        return diaryEntityList.stream()
                .map(createResponseGetAllDiaryDTOBean::exec)
                .collect(Collectors.toList());
    }
}
