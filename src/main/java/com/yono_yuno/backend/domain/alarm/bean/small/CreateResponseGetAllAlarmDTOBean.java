package com.yono_yuno.backend.domain.alarm.bean.small;

import com.yono_yuno.backend.domain.alarm.entity.AlarmEntity;
import com.yono_yuno.backend.domain.alarm.entity.dto.ResponseGetAllAlarmDTO;
import com.yono_yuno.backend.domain.cart.bean.small.GetCartEntityBean;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.diary.bean.small.GetDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.item.bean.small.GetItemEntityBean;
import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class CreateResponseGetAllAlarmDTOBean {
    private final GetCartEntityBean getCartEntityBean;
    private final GetDiaryEntityBean getDiaryEntityBean;
    private final GetItemEntityBean getItemEntityBean;

    public CreateResponseGetAllAlarmDTOBean(GetCartEntityBean getCartEntityBean, GetDiaryEntityBean getDiaryEntityBean, GetItemEntityBean getItemEntityBean) {
        this.getCartEntityBean = getCartEntityBean;
        this.getDiaryEntityBean = getDiaryEntityBean;
        this.getItemEntityBean = getItemEntityBean;
    }

    public ResponseGetAllAlarmDTO exec(AlarmEntity alarm) {
        ItemEntity item = null;

        if (alarm.getDiaryId() == null) {
            CartEntity cart = getCartEntityBean.exec(alarm.getCartId());
            item = getItemEntityBean.exec(cart.getItemId());
        } else {
            DiaryEntity diary = getDiaryEntityBean.exec(alarm.getDiaryId());
            item = getItemEntityBean.exec(diary.getItemId());
        }

        DateTimeFormatter alarmTimeFormatter = DateTimeFormatter.ofPattern("yy.MM.dd/HH:mm");

        return ResponseGetAllAlarmDTO.builder()
                .alarmId(alarm.getAlarmId())
                .itemName(item.getItemName())
                .nextPageName(alarm.getDiaryId() == null ? "cart" : "diary")
                .alarmTime(alarm.getCreatedAt().format(alarmTimeFormatter))
                .build();
    }
}
