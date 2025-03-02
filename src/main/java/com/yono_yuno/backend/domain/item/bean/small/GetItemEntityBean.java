package com.yono_yuno.backend.domain.item.bean.small;

import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import com.yono_yuno.backend.domain.item.repository.ItemRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetItemEntityBean {
    private final ItemRepositoryJPA itemRepositoryJPA;

    public GetItemEntityBean(ItemRepositoryJPA itemRepositoryJPA) {
        this.itemRepositoryJPA = itemRepositoryJPA;
    }

    public ItemEntity exec(UUID itemId) {
        return  itemRepositoryJPA.findById(itemId).orElse(null);
    }
}