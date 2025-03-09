package com.yono_yuno.backend.domain.diary.bean.matching;

import com.yono_yuno.backend.domain.diary.bean.small.GetPriceCategoryBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
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

        return  categoryPrice;
    }
}
