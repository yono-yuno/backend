package com.yono_yuno.backend.domain.diary.bean.statistic.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.statistic.LineGraphData;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CreateResponseLineGraph {
    public List<LineGraphData> exec(Map<Integer,Integer> current, Map<Integer,Integer> prev){
        List<LineGraphData> lineGraphData =new ArrayList<>();

        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(WeekFields.of(Locale.US).dayOfWeek(), 7);
        LocalDate endOfWeek = startOfWeek.plusDays(6);

        for (int day = 1; day <= 31; day++) {
            Integer currentPay = current.get(day); // 지난달 데이터 (없으면 0)
            Integer prevPay = prev.get(day); // 이번 달 데이터 (없으면 null)

            LocalDate date = LocalDate.of(today.getYear(), today.getMonth(), day);
            boolean isThisWeek = !date.isBefore(startOfWeek) && !date.isAfter(endOfWeek);

            LineGraphData data = new LineGraphData(day, prevPay, currentPay, isThisWeek);
            lineGraphData.add(data);
        }

        return lineGraphData;
    }
}
