package com.yono_yuno.backend.domain.diary.bean.statistic.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.item.ItemEntity;
import com.yono_yuno.backend.domain.item.ItemRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class GetPriceCategory {
    private final ItemRepositoryJPA itemRepositoryJPA;

    public GetPriceCategory(ItemRepositoryJPA itemRepositoryJPA){
        this.itemRepositoryJPA=itemRepositoryJPA;
    }
    public Map<String, Object> exec(DiaryEntity diary){
        ItemEntity item = itemRepositoryJPA.findByItemId(diary.getItemId());

        int price = item.getPrice();
        String category = item.getCategory();

        Map<String, Object> map = new HashMap<>();
        map.put("price", price);
        map.put("category", category);
        return map;
    }
}
