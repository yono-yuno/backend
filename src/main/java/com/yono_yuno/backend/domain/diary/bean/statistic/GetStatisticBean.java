package com.yono_yuno.backend.domain.diary.bean.statistic;

import com.yono_yuno.backend.domain.diary.bean.statistic.small.CreateResponseStatisticBean;
import com.yono_yuno.backend.domain.diary.bean.statistic.small.CreateResponseLineGraph;
import com.yono_yuno.backend.domain.diary.bean.statistic.small.CreateResponsePieGraph;
import com.yono_yuno.backend.domain.diary.bean.statistic.small.GetAllMonthDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.statistic.ResponseGetStatistic;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Component
public class GetStatisticBean {
    private final CreateResponseStatisticBean createResponseStatisticBean;
    private final GetAllMonthDiaryEntityBean getAllMonthDiaryEntityBean;

    public GetStatisticBean(GetAllMonthDiaryEntityBean getAllMonthDiaryEntityBean,CreateResponseStatisticBean createResponseStatisticBean){
        this.getAllMonthDiaryEntityBean=getAllMonthDiaryEntityBean;
        this.createResponseStatisticBean=createResponseStatisticBean;
    }
    public ResponseGetStatistic exec(UUID userId){
        YearMonth nowMonth= YearMonth.now();
        String yearMonthString = nowMonth.format(DateTimeFormatter.ofPattern("yyyyMM"));
        List<DiaryEntity> current = getAllMonthDiaryEntityBean.exec(userId,yearMonthString);

        if(current == null){
            throw new CustomException(ErrorCode.CURRENT_NOT_FOUND);
        }

        String prevYearMonthString = nowMonth.minusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMM"));
        List<DiaryEntity> prev = getAllMonthDiaryEntityBean.exec(userId,prevYearMonthString);
        if(prev == null){
            throw new CustomException(ErrorCode.PREV_NOT_FOUND);
        }
        return createResponseStatisticBean.exec(current,prev);
    }

}
