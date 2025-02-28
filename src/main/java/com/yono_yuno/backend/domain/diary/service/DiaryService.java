package com.yono_yuno.backend.domain.diary.service;

import com.yono_yuno.backend.domain.diary.bean.CreateDiaryBean;
import com.yono_yuno.backend.domain.diary.entity.dto.RequestSaveDiaryDto;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseSaveDiaryDto;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {
    private final CreateDiaryBean createDiaryBean;

    public DiaryService(CreateDiaryBean createDiaryBean){
        this.createDiaryBean=createDiaryBean;
    }

    public ResponseSaveDiaryDto write(RequestSaveDiaryDto requestSaveDiaryDto){
        return createDiaryBean.exec(requestSaveDiaryDto);
    }
}
