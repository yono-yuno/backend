package com.yono_yuno.backend.domain.diary.bean.statistic.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.statistic.LineGraphData;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class CreateResponseLineGraph {
    private final DatePriceMatching datePriceMatching;
    private final MonthMatching monthMatching;

    public CreateResponseLineGraph(DatePriceMatching datePriceMatching, MonthMatching monthMatching) {
        this.datePriceMatching = datePriceMatching;
        this.monthMatching = monthMatching;
    }

    public List<LineGraphData> exec(List<DiaryEntity> current, List<DiaryEntity> prev){

        Map<Integer, Integer> currentDateMatching = datePriceMatching.exec(current);
        if (currentDateMatching ==  null ){
            throw new CustomException(ErrorCode.DATE_PRICE_MATCHING_FAIL);
        }

        Map<Integer, Integer> prevDateMatching = datePriceMatching.exec(prev);
        if (prevDateMatching ==  null ){
            throw new CustomException(ErrorCode.DATE_PRICE_MATCHING_FAIL);
        }

        return monthMatching.exec(currentDateMatching,prevDateMatching);
    }

}
