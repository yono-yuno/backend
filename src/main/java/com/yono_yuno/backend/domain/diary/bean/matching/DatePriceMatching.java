package com.yono_yuno.backend.domain.diary.bean.matching;

import com.yono_yuno.backend.domain.diary.bean.small.GetPriceCategoryBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class DatePriceMatching {
    private final GetPriceCategoryBean getPriceCategoryBean;

    public DatePriceMatching(GetPriceCategoryBean getPriceCategoryBean){
        this.getPriceCategoryBean = getPriceCategoryBean;
    }
    public Map<Integer,Integer> exec(List<DiaryEntity> entityList){
        Map<Integer,Integer> monthStatistic = new HashMap<>();

        for (DiaryEntity diary : entityList) {
            int date = diary.getCreatedAt().getDayOfMonth();
            Map<String, Object> item= getPriceCategoryBean.exec(diary);
            int price= (int)item.get("price");
            monthStatistic.put(date, monthStatistic.getOrDefault(date, 0) + price);
        }
        return monthStatistic;
    }
}
