package com.yono_yuno.backend.domain.diary.bean.matching;

import com.yono_yuno.backend.domain.diary.bean.small.GetPriceCategoryBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class CategoryMatching {
    private final GetPriceCategoryBean getPriceCategoryBean;

    public CategoryMatching(GetPriceCategoryBean getPriceCategoryBean) {
        this.getPriceCategoryBean = getPriceCategoryBean;
    }

    public Map<String,Integer> exec(List<DiaryEntity> currents) {
        Map<String,Integer> categoryPrice = new HashMap<>();

        for (DiaryEntity diary : currents) {
            Map<String, Object> item = getPriceCategoryBean.exec(diary);
            String category = (String)item.get("category");
            int price = (int)item.get("price");

            categoryPrice.put(category, categoryPrice.getOrDefault(category, 0) + price);
        }
        //카테고리별 합산 금액 정렬
        Map<String, Integer> sortedCategoryPrice= categoryPrice.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // 금액 내림차순 정렬
                .collect(
                        LinkedHashMap::new,
                        (categoryPriceSort, entry) -> categoryPriceSort.put(entry.getKey(), entry.getValue()),
                        Map::putAll
                );

        Map<String, Integer> top4 = new LinkedHashMap<>();
        int remainPrice = 0;
        int count = 0;

        for (Map.Entry<String, Integer> entity : sortedCategoryPrice.entrySet()) {
            if (count < 4) {
                top4.put(entity.getKey(), entity.getValue());
            } else {
                remainPrice += entity.getValue();
            }
            count++;
        }
        top4.put("그 외", remainPrice);

        return top4;
    }
}
