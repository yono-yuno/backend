package com.yono_yuno.backend.domain.diary.bean;

import com.yono_yuno.backend.domain.diary.bean.small.CreateResponseGetAllDiaryDTOBean;
import com.yono_yuno.backend.domain.diary.bean.small.CreateResponseGetDiaryDTOBean;
import com.yono_yuno.backend.domain.diary.bean.small.GetAllDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.bean.small.GetDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetAllDiaryDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class GetAllDiaryBean {
    private final GetAllDiaryEntityBean getAllDiaryEntityBean;
    private final CreateResponseGetAllDiaryDTOBean createResponseGetAllDiaryDTOBean;

    public GetAllDiaryBean(GetAllDiaryEntityBean getAllDiaryEntityBean, CreateResponseGetAllDiaryDTOBean createResponseGetAllDiaryDTOBean){
        this.getAllDiaryEntityBean=getAllDiaryEntityBean;
        this.createResponseGetAllDiaryDTOBean=createResponseGetAllDiaryDTOBean;
    }
    public List<ResponseGetAllDiaryDTO> exec(UUID userId){
        List<DiaryEntity> diaryEntityList =getAllDiaryEntityBean.exec(userId);

        return diaryEntityList.stream()
                .map(createResponseGetAllDiaryDTOBean::exec)
                .collect(Collectors.toList());
    }
}
