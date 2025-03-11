package com.yono_yuno.backend.domain.diary.bean;

import com.yono_yuno.backend.domain.diary.bean.small.CreateResponseStatisticBean;
import com.yono_yuno.backend.domain.diary.bean.small.GetAllMonthDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetStatisticDTO;
import com.yono_yuno.backend.domain.user.bean.small.GetUserEntityBean;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Component
public class GetStatisticBean {
    private final GetUserEntityBean getUserEntityBean;
    private final CreateResponseStatisticBean createResponseStatisticBean;
    private final GetAllMonthDiaryEntityBean getAllMonthDiaryEntityBean;

    public GetStatisticBean(GetUserEntityBean getUserEntityBean, GetAllMonthDiaryEntityBean getAllMonthDiaryEntityBean,CreateResponseStatisticBean createResponseStatisticBean) {
        this.getUserEntityBean = getUserEntityBean;
        this.getAllMonthDiaryEntityBean = getAllMonthDiaryEntityBean;
        this.createResponseStatisticBean = createResponseStatisticBean;
    }

    public ResponseGetStatisticDTO exec(UUID userId) {
        UserEntity user = getUserEntityBean.exec(userId);
        if (user == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        YearMonth nowMonth = YearMonth.now();
        String yearMonthString = nowMonth.format(DateTimeFormatter.ofPattern("yyyyMM"));
        List<DiaryEntity> current = getAllMonthDiaryEntityBean.exec(userId, yearMonthString);
        if (current == null) {
            throw new CustomException(ErrorCode.CURRENT_NOT_FOUND);
        }

        String prevYearMonthString = nowMonth.minusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMM"));
        List<DiaryEntity> prev = getAllMonthDiaryEntityBean.exec(userId, prevYearMonthString);
        if (prev == null) {
            throw new CustomException(ErrorCode.PREV_NOT_FOUND);
        }

        return createResponseStatisticBean.exec(current, prev);
    }
}
