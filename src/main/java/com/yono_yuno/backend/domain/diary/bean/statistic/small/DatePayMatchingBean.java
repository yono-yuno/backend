package com.yono_yuno.backend.domain.diary.bean.statistic.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DatePayMatchingBean {
    public Map<Integer, Double> getAmountForDate(List<DiaryEntity> diarys) {
        // 날짜별로 금액을 저장할 맵
        return diarys.stream()
                .collect(Collectors.groupingBy(
                        diary -> diary.getCreatedAt().getDayOfMonth(),  // 날짜 기준으로 그룹화
                        Collectors.summingDouble(diary -> getItemPriceBean(diary.getItemId()))  // 금액 계산
                ));
    }
}
