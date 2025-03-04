package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.GetItemInfo;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetAllDiaryDTO;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetDiaryDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateResponseGetAllDiaryDTOBean {

    public ResponseGetAllDiaryDTO exec(DiaryEntity diary){
        return ResponseGetAllDiaryDTO.builder()
                .diaryId(diary.getDiaryId())
                .itemInfo(GetItemInfo.builder().build())
                .build();
    }

}
