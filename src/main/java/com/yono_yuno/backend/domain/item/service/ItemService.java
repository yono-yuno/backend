package com.yono_yuno.backend.domain.item.service;

import com.yono_yuno.backend.domain.item.bean.GetItemBean;
import com.yono_yuno.backend.domain.item.entity.dto.ResponseGetItemAllDTO;
import com.yono_yuno.backend.domain.item.entity.dto.ResponseGetItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

    private final GetItemBean getItemBean;

    public ItemService(GetItemBean getItemBean) {
        this.getItemBean = getItemBean;
    }

    public ResponseGetItemDTO getItem(UUID itemId) {
        return getItemBean.exec(itemId);
    }

    public List<ResponseGetItemAllDTO> getItemsByCategory(String category) {
        return getItemBean.exec(category);
    }
}
