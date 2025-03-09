package com.yono_yuno.backend.domain.item.bean;

import com.yono_yuno.backend.domain.item.bean.small.CreateResponseGetItemAllDTOBean;
import com.yono_yuno.backend.domain.item.bean.small.CreateResponseGetItemDTOBean;
import com.yono_yuno.backend.domain.item.bean.small.GetAllItemEntityBean;
import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import com.yono_yuno.backend.domain.item.entity.dto.ResponseGetItemAllDTO;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllItemBean {
    private final GetAllItemEntityBean getAllItemEntityBean;
    private final CreateResponseGetItemAllDTOBean createResponseGetItemAllDTOBean;

    public GetAllItemBean(GetAllItemEntityBean getAllItemEntityBean, CreateResponseGetItemDTOBean createResponseGetItemDTOBean, CreateResponseGetItemAllDTOBean createResponseGetItemAllDTOBean) {
        this.getAllItemEntityBean = getAllItemEntityBean;
        this.createResponseGetItemAllDTOBean = createResponseGetItemAllDTOBean;
    }

    public List<ResponseGetItemAllDTO> exec(String category, String sort) {
        List<ItemEntity> itemEntityList;
        if (category.equals("전체")) {
            itemEntityList = getAllItemEntityBean.exec();
        } else {
            itemEntityList = getAllItemEntityBean.exec(category);
        }

        if (itemEntityList.isEmpty()) {
            throw new CustomException(ErrorCode.ITEM_NOT_FOUND);
        }

        List<ResponseGetItemAllDTO> items = itemEntityList.stream().map(createResponseGetItemAllDTOBean::exec).toList();

        if (sort != null) {
            switch (sort) {
                case "latest":
                    return items.stream()
                            .sorted(Comparator.comparing(
                                    ResponseGetItemAllDTO::getCreatedAt,
                                    Comparator.nullsLast(Comparator.naturalOrder()) // null 값을 마지막으로 정렬
                            ).reversed())
                            .collect(Collectors.toList());
                case "oldest":
                    return items.stream()
                            .sorted(Comparator.comparing(ResponseGetItemAllDTO::getCreatedAt))
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
