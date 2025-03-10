package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetDiaryDTO;
import com.yono_yuno.backend.domain.item.bean.small.CreateItemInfoDTOBean;
import com.yono_yuno.backend.domain.item.bean.small.GetItemEntityBean;
import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import com.yono_yuno.backend.domain.item.entity.dto.ItemInfoDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateResponseGetDiaryDTOBean {
    private final GetItemEntityBean getItemEntityBean;
    private final CreateItemInfoDTOBean createItemInfoDTOBean;

    public CreateResponseGetDiaryDTOBean(GetItemEntityBean getItemEntityBean, CreateItemInfoDTOBean createItemInfoDTOBean) {
        this.getItemEntityBean = getItemEntityBean;
        this.createItemInfoDTOBean = createItemInfoDTOBean;
    }

    public ResponseGetDiaryDTO exec(DiaryEntity diary) {
        ItemEntity item = getItemEntityBean.exec(diary.getItemId());
        ItemInfoDTO itemInfoDTO = createItemInfoDTOBean.exec(item);

        return ResponseGetDiaryDTO.builder()
                .diaryId(diary.getDiaryId())
                .userId(diary.getUserId())
                .consumerStars(diary.getConsumerStars())
                .firstReview(diary.getFirstReview())
                .detailDiary(diary.getDetailDiary())
                .itemInfo(itemInfoDTO)
                .build();
    }
}
