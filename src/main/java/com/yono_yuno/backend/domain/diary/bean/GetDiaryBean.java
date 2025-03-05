package com.yono_yuno.backend.domain.diary.bean;

import com.yono_yuno.backend.domain.diary.bean.small.CreateResponseGetDiaryDTOBean;
import com.yono_yuno.backend.domain.diary.bean.small.GetDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetDiaryDTO;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetDiaryBean {
    //일기 조회
    //일기 조회 응답
    private final CreateResponseGetDiaryDTOBean createResponseGetDiaryDTOBean;
    private final GetDiaryEntityBean getDiaryEntityBean;

    public GetDiaryBean(CreateResponseGetDiaryDTOBean createResponseGetDiaryDTOBean, GetDiaryEntityBean getDiaryEntityBean){
        this.createResponseGetDiaryDTOBean=createResponseGetDiaryDTOBean;
        this.getDiaryEntityBean=getDiaryEntityBean;
    }

    public ResponseGetDiaryDTO exec(UUID diaryId){
        DiaryEntity diary= getDiaryEntityBean.exec(diaryId);

        if (diary ==null){
            throw new CustomException(ErrorCode.DIARY_NOT_FOUND);

        }
        return createResponseGetDiaryDTOBean.exec(diary);
    }


}
