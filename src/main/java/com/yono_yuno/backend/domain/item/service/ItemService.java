package com.yono_yuno.backend.domain.item.service;

import com.yono_yuno.backend.domain.item.bean.GetItemBean;
import com.yono_yuno.backend.domain.item.entity.dto.ResponseGetItemAllDTO;
import com.yono_yuno.backend.domain.item.entity.dto.ResponseGetItemDTO;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final GetItemBean getItemBean;

    public ItemService(GetItemBean getItemBean) {
        this.getItemBean = getItemBean;
    }

    public ResponseGetItemDTO getItem(UUID itemId) {
        return getItemBean.exec(itemId);
    }

    public List<ResponseGetItemAllDTO> getItemsByCategory(String category, String sort) {
        List<ResponseGetItemAllDTO> items = getItemBean.exec(category);

        if(sort != null) {
            switch (sort) {
                case "latest":
                    return items.stream()
                            .sorted(Comparator.comparing(
                                    ResponseGetItemAllDTO::getCreateAt,
                                    Comparator.nullsLast(Comparator.naturalOrder()) // null 값을 마지막으로 정렬
                            ).reversed())
//                            .sorted(Comparator.comparing(ResponseGetItemAllDTO::getCreateAt).reversed())
                            .collect(Collectors.toList());
                case "oldest":
                    return items.stream()
                            .sorted(Comparator.comparing(ResponseGetItemAllDTO::getCreateAt))
                            .collect(Collectors.toList());
                case "highPrice":
                    return items.stream()
                            .sorted(Comparator.comparing(ResponseGetItemAllDTO::getPrice).reversed())
                            .collect(Collectors.toList());
                case "lowPrice":
                    return items.stream()
                            .sorted(Comparator.comparing(ResponseGetItemAllDTO::getPrice))
                            .collect(Collectors.toList());
            }
        }
        return items;
    }
}
