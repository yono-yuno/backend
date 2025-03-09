package com.yono_yuno.backend.domain.item.service;

import com.yono_yuno.backend.domain.item.bean.GetAllItemBean;
import com.yono_yuno.backend.domain.item.bean.GetItemBean;
import com.yono_yuno.backend.domain.item.entity.dto.ResponseGetItemAllDTO;
import com.yono_yuno.backend.domain.item.entity.dto.ResponseGetItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    private final GetItemBean getItemBean;
    private final GetAllItemBean getAllItemBean;

    public ItemService(GetItemBean getItemBean, GetAllItemBean getAllItemBean) {
        this.getItemBean = getItemBean;
        this.getAllItemBean = getAllItemBean;
    }

    public ResponseGetItemDTO getItem(UUID itemId) {
        return getItemBean.exec(itemId);
    }

    public List<ResponseGetItemAllDTO> getAll(String category, String sort) {
        return getAllItemBean.exec(category, sort);
    }

}
