package com.yono_yuno.backend.domain.diary.bean;

import com.yono_yuno.backend.domain.diary.bean.small.CreateDiaryDTOBean;
import com.yono_yuno.backend.domain.diary.bean.small.CreateDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.bean.small.SaveDairyEntityBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.RequestCreateDiaryDTO;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseCreateDiaryDTO;
import com.yono_yuno.backend.domain.item.bean.small.GetItemEntityBean;
import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import com.yono_yuno.backend.domain.user.bean.small.GetUserEntityBean;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class CreateDiaryBean {
    private final GetUserEntityBean getUserEntityBean;
    private final GetItemEntityBean getItemEntityBean;
    private final CreateDiaryEntityBean createDiaryEntityBean;
    private final CreateDiaryDTOBean createDiaryDtoBean;
    private final SaveDairyEntityBean saveDairyEntitybean;

    public CreateDiaryBean(GetUserEntityBean getUserEntityBean, GetItemEntityBean getItemEntityBean, CreateDiaryEntityBean createDiaryEntityBean, CreateDiaryDTOBean createDiaryDtoBean, SaveDairyEntityBean saveDairyEntitybean) {
        this.getUserEntityBean = getUserEntityBean;
        this.getItemEntityBean = getItemEntityBean;
        this.createDiaryEntityBean = createDiaryEntityBean;
        this.createDiaryDtoBean= createDiaryDtoBean;
        this.saveDairyEntitybean = saveDairyEntitybean;
    }

    public ResponseCreateDiaryDTO exec(RequestCreateDiaryDTO requestCreateDiaryDto) {
        UserEntity user = getUserEntityBean.exec(requestCreateDiaryDto.getUserId());
        if (user == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        ItemEntity item = getItemEntityBean.exec(requestCreateDiaryDto.getItemId());
        if (item == null) {
            throw new CustomException(ErrorCode.ITEM_NOT_FOUND);
        }

        DiaryEntity diaryEntity = createDiaryEntityBean.exec(requestCreateDiaryDto);
        saveDairyEntitybean.exec(diaryEntity);

        return createDiaryDtoBean.exec(diaryEntity);
    }
}
