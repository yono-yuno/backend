package com.yono_yuno.backend.domain.item.bean.small;

import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import com.yono_yuno.backend.domain.item.repository.ItemRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllItemEntityBean {
    private final ItemRepositoryJPA itemRepositoryJPA;

    public GetAllItemEntityBean(ItemRepositoryJPA itemRepositoryJPA) {
        this.itemRepositoryJPA = itemRepositoryJPA;
    }

    public List<ItemEntity> exec(String category) {
        return itemRepositoryJPA.findAllByCategory(category);
    }

    public List<ItemEntity> exec() {
        return itemRepositoryJPA.findAll();
    }
}
