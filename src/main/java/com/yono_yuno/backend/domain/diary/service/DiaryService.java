package com.yono_yuno.backend.domain.diary.service;

import com.yono_yuno.backend.domain.diary.bean.CreateDiaryBean;
import com.yono_yuno.backend.domain.diary.bean.GetDiaryBean;
import com.yono_yuno.backend.domain.diary.bean.UpdateDiaryBean;
import com.yono_yuno.backend.domain.diary.entity.dto.RequestSaveDiaryDTO;
import com.yono_yuno.backend.domain.diary.entity.dto.RequestUpdateDiaryDTO;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetDiaryDTO;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseSaveDiaryDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DiaryService {
    private final CreateDiaryBean createDiaryBean;
    private final GetDiaryBean getDiaryBean;
    private final UpdateDiaryBean updateDiaryBean;
    public DiaryService(CreateDiaryBean createDiaryBean, GetDiaryBean getDiaryBean, UpdateDiaryBean updateDiaryBean){
        this.createDiaryBean=createDiaryBean;
        this.getDiaryBean= getDiaryBean;
        this.updateDiaryBean = updateDiaryBean;
    }

    public ResponseSaveDiaryDTO write(RequestSaveDiaryDTO requestSaveDiaryDto){
        return createDiaryBean.exec(requestSaveDiaryDto);
    }
    public ResponseGetDiaryDTO getDiary(UUID diaryId){
        return getDiaryBean.exec(diaryId);
    }
    public boolean update(RequestUpdateDiaryDTO requestUpdateDiaryDTO){
        return updateDiaryBean.exec(requestUpdateDiaryDTO);
    }
}
