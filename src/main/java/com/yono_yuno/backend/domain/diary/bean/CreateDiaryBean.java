package com.yono_yuno.backend.domain.diary.bean;

import com.yono_yuno.backend.domain.diary.bean.small.CreateDiaryDtoBean;
import com.yono_yuno.backend.domain.diary.bean.small.CreateDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.bean.small.SaveDairyEntityBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.RequestCreateDiaryDTO;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseCreateDiaryDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateDiaryBean {
    private final CreateDiaryEntityBean createDiaryEntityBean;
    private final CreateDiaryDtoBean createDiaryDtoBean;
    private final SaveDairyEntityBean saveDairyEntitybean;

    public CreateDiaryBean(CreateDiaryEntityBean createDiaryEntityBean, CreateDiaryDtoBean createDiaryDtoBean, SaveDairyEntityBean saveDairyEntitybean){
        this.createDiaryEntityBean = createDiaryEntityBean;
        this.createDiaryDtoBean= createDiaryDtoBean;
        this.saveDairyEntitybean = saveDairyEntitybean;
    }

    public ResponseCreateDiaryDTO exec(RequestCreateDiaryDTO requestCreateDiaryDto) {
//        userid와 itemid 있는지 확인 추가 예정
        DiaryEntity diaryEntity = createDiaryEntityBean.exec(requestCreateDiaryDto);
        saveDairyEntitybean.exec(diaryEntity);

        return createDiaryDtoBean.exec(diaryEntity);
    }

}
