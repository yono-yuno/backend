package com.yono_yuno.backend.domain.diary.bean;

import com.yono_yuno.backend.domain.diary.bean.small.GetDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.bean.small.SaveDairyEntityBean;
import com.yono_yuno.backend.domain.diary.bean.small.UpdateDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.RequestUpdateDiaryDTO;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class UpdateDiaryBean {
    //일기 조회
    //일기 수정
    //일기 저장
    private final GetDiaryEntityBean getDiaryEntityBean;
    private final UpdateDiaryEntityBean updateDiaryEntityBean;
    private final SaveDairyEntityBean saveDairyEntityBean;

    public UpdateDiaryBean(GetDiaryEntityBean getDiaryEntityBean, UpdateDiaryEntityBean updateDiaryEntityBean, SaveDairyEntityBean saveDairyEntityBean){
        this.getDiaryEntityBean=getDiaryEntityBean;
        this.updateDiaryEntityBean=updateDiaryEntityBean;
        this.saveDairyEntityBean=saveDairyEntityBean;
    }

    public boolean exec(RequestUpdateDiaryDTO requestUpdateDiaryDTO){
        DiaryEntity diary=getDiaryEntityBean.exec(requestUpdateDiaryDTO.getDairyId());

        if(diary == null){
            throw new CustomException(ErrorCode.DIARY_NOT_FOUND);
        }

        DiaryEntity updateDiary = updateDiaryEntityBean.exec(diary, requestUpdateDiaryDTO.getConsumerStars(), requestUpdateDiaryDTO.getDetailDiary());

        if(updateDiary == null){
            return false;
        }

        saveDairyEntityBean.exec(updateDiary);
        return true;

    }
}
