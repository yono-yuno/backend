package com.yono_yuno.backend.domain.diary.bean.statistic.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.statistic.PieGraphData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class CategoryMatching {
    private final GetPriceCategory getPriceCategory;

    public CategoryMatching(GetPriceCategory getPriceCategory){
        this.getPriceCategory=getPriceCategory;
    }
    public Map<String,Integer> exec(List<DiaryEntity> currents){
        Map<String,Integer> categoryPrice = new HashMap<>();

        for(DiaryEntity diary : currents){
            Map<String, Object> item =getPriceCategory.exec(diary);
            String category = (String)item.get("category");
            int price =(int)item.get("price");

            categoryPrice.put(category, categoryPrice.getOrDefault(category, 0) + price);
        }


        return  categoryPrice;
    }
}
