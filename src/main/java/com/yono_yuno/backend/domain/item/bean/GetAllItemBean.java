package com.yono_yuno.backend.domain.item.bean;

import com.yono_yuno.backend.domain.item.bean.small.CreateResponseGetItemAllDTOBean;
import com.yono_yuno.backend.domain.item.bean.small.CreateResponseGetItemDTOBean;
import com.yono_yuno.backend.domain.item.bean.small.GetItemEntityBean;
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

    private final GetItemEntityBean getItemEntityBean;
    private final CreateResponseGetItemDTOBean createResponseGetItemDTOBean;
    private final CreateResponseGetItemAllDTOBean createResponseGetItemAllDTOBean;

    public GetAllItemBean(GetItemEntityBean getItemEntityBean, CreateResponseGetItemDTOBean createResponseGetItemDTOBean, CreateResponseGetItemAllDTOBean createResponseGetItemAllDTOBean) {
        this.getItemEntityBean = getItemEntityBean;
        this.createResponseGetItemDTOBean = createResponseGetItemDTOBean;
        this.createResponseGetItemAllDTOBean = createResponseGetItemAllDTOBean;
    }

        public List<ResponseGetItemAllDTO> exec(String category, String sort) {
       List<ItemEntity> itemList  = getItemEntityBean.exec(category);

        if(itemList.isEmpty()) {
            throw new CustomException(ErrorCode.ITEM_NOT_FOUND);
        }

        return itemList.stream().map(createResponseGetItemAllDTOBean::exec)
                .collect(Collectors.toList());
    }

    public List<ResponseGetItemAllDTO> getItemsByCategory(String category, String sort) {
        List<ResponseGetItemAllDTO> items = this.exec(category, sort);

        if(sort != null) {
            switch (sort) {
                case "latest":
                    return items.stream()
                            .sorted(Comparator.comparing(
                                    ResponseGetItemAllDTO::getCreateAt,
                                    Comparator.nullsLast(Comparator.naturalOrder()) // null 값을 마지막으로 정렬
                            ).reversed())
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
        return null;
    }
}
