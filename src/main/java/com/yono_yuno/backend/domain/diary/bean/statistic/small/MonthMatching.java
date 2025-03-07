package com.yono_yuno.backend.domain.diary.bean.statistic.small;

import com.yono_yuno.backend.domain.diary.entity.dto.statistic.LineGraphData;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.*;
@Component
public class MonthMatching {
    public List<LineGraphData> exec(Map<Integer,Integer> current, Map<Integer,Integer> prev){
        List<LineGraphData> lineGraphData =new ArrayList<>();

        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(WeekFields.of(Locale.US).dayOfWeek(), 1);
        LocalDate endOfWeek = startOfWeek.plusDays(6);

        for (int day = 1; day <= 31; day++) {
            Integer currentPay = Optional.ofNullable(current.get(day)).orElse(0);
            Integer prevPay = Optional.ofNullable(prev.get(day)).orElse(0);

            LocalDate date = LocalDate.of(today.getYear(), today.getMonth(), day);
            boolean isThisWeek = !date.isBefore(startOfWeek) && !date.isAfter(endOfWeek);

            LineGraphData data = new LineGraphData(day, prevPay, currentPay, isThisWeek);
            lineGraphData.add(data);
        }

        return lineGraphData;
    }
}
