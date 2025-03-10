package com.yono_yuno.backend.domain.diary.service;

import com.yono_yuno.backend.domain.diary.bean.CreateDiaryBean;
import com.yono_yuno.backend.domain.diary.bean.GetAllDiaryBean;
import com.yono_yuno.backend.domain.diary.bean.GetDiaryBean;
import com.yono_yuno.backend.domain.diary.bean.UpdateDiaryBean;
import com.yono_yuno.backend.domain.diary.bean.GetStatisticBean;
import com.yono_yuno.backend.domain.diary.entity.dto.*;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetStatisticDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DiaryService {
    private final CreateDiaryBean createDiaryBean;
    private final GetDiaryBean getDiaryBean;
    private final UpdateDiaryBean updateDiaryBean;
    private final GetAllDiaryBean getAllDiaryBean;
    private final GetStatisticBean getStatisticBean;

    public DiaryService(GetAllDiaryBean getAllDiaryBean,CreateDiaryBean createDiaryBean, GetDiaryBean getDiaryBean, UpdateDiaryBean updateDiaryBean,GetStatisticBean getStatisticBean) {
        this.createDiaryBean=createDiaryBean;
        this.getAllDiaryBean=getAllDiaryBean;
        this.getDiaryBean= getDiaryBean;
        this.updateDiaryBean = updateDiaryBean;
        this.getStatisticBean=getStatisticBean;
    }

    public ResponseCreateDiaryDTO write(RequestCreateDiaryDTO requestCreateDiaryDto) {
        return createDiaryBean.exec(requestCreateDiaryDto);
    }

    public ResponseGetDiaryDTO getDiary(UUID diaryId){
        return getDiaryBean.exec(diaryId);
    }

    public boolean update(RequestUpdateDiaryDTO requestUpdateDiaryDTO) {
        return updateDiaryBean.exec(requestUpdateDiaryDTO);
    }

    public List<ResponseGetAllDiaryDTO> getAllDiary(UUID userId){
        return getAllDiaryBean.exec(userId);
    }

    public ResponseGetStatisticDTO statistic(UUID userId){
        return getStatisticBean.exec(userId);
    }
}
