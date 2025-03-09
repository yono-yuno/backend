package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetAllDiaryDTO;
import com.yono_yuno.backend.domain.item.bean.small.CreateItemInfoDTOBean;
import com.yono_yuno.backend.domain.item.bean.small.GetItemEntityBean;
import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import com.yono_yuno.backend.domain.item.entity.dto.ItemInfoDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateResponseGetAllDiaryDTOBean {
    private final GetItemEntityBean getItemEntityBean;
    private final CreateItemInfoDTOBean createItemInfoDTOBean;

    public CreateResponseGetAllDiaryDTOBean(GetItemEntityBean getItemEntityBean, CreateItemInfoDTOBean createItemInfoDTOBean) {
        this.getItemEntityBean = getItemEntityBean;
        this.createItemInfoDTOBean = createItemInfoDTOBean;
    }

    public ResponseGetAllDiaryDTO exec(DiaryEntity diary) {
        ItemEntity item = getItemEntityBean.exec(diary.getItemId());
        ItemInfoDTO itemInfoDTO = createItemInfoDTOBean.exec(item);

        return ResponseGetAllDiaryDTO.builder()
                .diaryId(diary.getDiaryId())
                .createdAt(diary.getCreatedAt())
                .itemInfo(itemInfoDTO)
                .build();
    }
}
