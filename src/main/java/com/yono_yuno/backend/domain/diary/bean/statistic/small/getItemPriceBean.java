package com.yono_yuno.backend.domain.diary.bean.statistic.small;

import java.util.UUID;

public class getItemPriceBean {
    private final GetItemEntityBean getItemEntityBean;

    public DatePayMatchingBean(GetItemEntityBean getItemEntityBean) {
        this.getItemEntityBean = getItemEntityBean;
    }

    public double getAmountForItem(UUID itemId) {

        ItemEntity itemEntity = getItemEntityBean(itemId);
        return itemEntity.getPrice();
    }
}
