package com.yono_yuno.backend.domain.diary.bean.statistic.small;

import com.yono_yuno.backend.domain.diary.bean.small.GetDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.statistic.ItemEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.statistic.LineGraphData;
import com.yono_yuno.backend.domain.diary.repository.ItemRepositoryJPA;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiaryStatistics {
    public Map<Integer,Integer> exec(List<DiaryEntity> entityList){
        Map<Integer,Integer> monthStatistic= new HashMap<>();

        for (DiaryEntity diary : entityList) {
            int date =diary.getCreatedAt().getDayOfMonth();

            ItemEntity item = ItemRepositoryJPA.findByItemId(diary.getItemId());
            int price = item.getPrice();
            monthStatistic.merge(date,price,Integer::sum);
        }
        return monthStatistic;
    }
}
