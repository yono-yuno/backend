package com.yono_yuno.backend.domain.diary.bean;

import com.yono_yuno.backend.domain.diary.bean.small.CreateResponseGetAllDiaryDTOBean;
import com.yono_yuno.backend.domain.diary.bean.small.GetAllDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetAllDiaryDTO;
import com.yono_yuno.backend.domain.item.bean.GetItemBean;
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
    private final GetItemBean getItemBean;

    public GetAllDiaryBean(GetUserEntityBean getUserEntityBean, GetAllDiaryEntityBean getAllDiaryEntityBean, CreateResponseGetAllDiaryDTOBean createResponseGetAllDiaryDTOBean, GetItemBean getItemBean) {
        this.getUserEntityBean = getUserEntityBean;
        this.getAllDiaryEntityBean=getAllDiaryEntityBean;
        this.createResponseGetAllDiaryDTOBean=createResponseGetAllDiaryDTOBean;
        this.getItemBean=getItemBean;
    }

    public List<ResponseGetAllDiaryDTO> exec(UUID userId, String category) {
        UserEntity user = getUserEntityBean.exec(userId);
        if (user == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        List<DiaryEntity> diaryEntityList;
        if(category.equals("전체")) {
            diaryEntityList = getAllDiaryEntityBean.exec(userId);
        }else {
            diaryEntityList = getAllDiaryEntityBean.exec(userId);

            diaryEntityList = diaryEntityList.stream()
                    .filter(diaryEntity -> {
                        UUID itemId = diaryEntity.getItemId();
                        String itemCategory = getItemBean.exec(itemId).getCategory();
                        return itemCategory.equals(category);  // itemCategory와 전달된 category를 비교하여 일치하는 것만 필터링
                    })
                    .collect(Collectors.toList());
        }
        return diaryEntityList.stream()
                .map(createResponseGetAllDiaryDTOBean::exec)
                .collect(Collectors.toList());
    }
}
