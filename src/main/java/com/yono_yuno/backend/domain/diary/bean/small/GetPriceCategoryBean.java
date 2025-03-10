package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.item.bean.small.GetItemEntityBean;
import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GetPriceCategoryBean {
    private final GetItemEntityBean getItemEntityBean;

    public GetPriceCategoryBean(GetItemEntityBean getItemEntityBean) {
        this.getItemEntityBean = getItemEntityBean;
    }

    public Map<String, Object> exec(DiaryEntity diary) {
        ItemEntity item = getItemEntityBean.exec(diary.getItemId());

        int price = item.getPrice();
        String category = item.getCategory();

        Map<String, Object> map = new HashMap<>();
        map.put("price", price);
        map.put("category", category);
        return map;
    }
}
