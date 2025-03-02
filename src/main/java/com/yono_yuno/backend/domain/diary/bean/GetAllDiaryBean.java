package com.yono_yuno.backend.domain.diary.bean;

import com.yono_yuno.backend.domain.diary.bean.small.GetAllDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.bean.small.GetDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllDiaryBean {
    private final GetAllDiaryEntityBean getAllDiaryEntityBean;

    public GetAllDiaryBean(GetAllDiaryEntityBean getAllDiaryEntityBean){
        this.getAllDiaryEntityBean=getAllDiaryEntityBean;
    }
    public List<DiaryEntity> exec(){
        return getAllDiaryEntityBean.exec();
    }
}
