package com.yono_yuno.backend.domain.diary.service;

import com.yono_yuno.backend.domain.diary.bean.CreateDiaryBean;
import com.yono_yuno.backend.domain.diary.bean.GetAllDiaryBean;
import com.yono_yuno.backend.domain.diary.bean.GetDiaryBean;
import com.yono_yuno.backend.domain.diary.bean.UpdateDiaryBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.RequestCreateDiaryDTO;
import com.yono_yuno.backend.domain.diary.entity.dto.RequestUpdateDiaryDTO;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetDiaryDTO;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseCreateDiaryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DiaryService {
    private final CreateDiaryBean createDiaryBean;
    private final GetDiaryBean getDiaryBean;
    private final UpdateDiaryBean updateDiaryBean;
    private final GetAllDiaryBean getAllDiaryBean;

    public DiaryService(GetAllDiaryBean getAllDiaryBean,CreateDiaryBean createDiaryBean, GetDiaryBean getDiaryBean, UpdateDiaryBean updateDiaryBean){
        this.createDiaryBean=createDiaryBean;
        this.getAllDiaryBean=getAllDiaryBean;
        this.getDiaryBean= getDiaryBean;
        this.updateDiaryBean = updateDiaryBean;
    }

    public ResponseCreateDiaryDTO write(RequestCreateDiaryDTO requestCreateDiaryDto){
        return createDiaryBean.exec(requestCreateDiaryDto);
    }
    public ResponseGetDiaryDTO getDiary(UUID diaryId){
        return getDiaryBean.exec(diaryId);
    }
    public boolean update(RequestUpdateDiaryDTO requestUpdateDiaryDTO){
        return updateDiaryBean.exec(requestUpdateDiaryDTO);
    }
    public List<DiaryEntity> getAllDiary(UUID userId){
        return getAllDiaryBean.exec();
    }
}
