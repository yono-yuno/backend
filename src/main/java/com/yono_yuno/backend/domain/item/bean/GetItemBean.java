package com.yono_yuno.backend.domain.item.bean;

import com.yono_yuno.backend.domain.item.bean.small.CreateResponseGetItemAllDTOBean;
import com.yono_yuno.backend.domain.item.bean.small.CreateResponseGetItemDTOBean;
import com.yono_yuno.backend.domain.item.bean.small.GetItemEntityBean;
import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import com.yono_yuno.backend.domain.item.entity.dto.ResponseGetItemAllDTO;
import com.yono_yuno.backend.domain.item.entity.dto.ResponseGetItemDTO;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class GetItemBean {

    private final GetItemEntityBean getItemEntityBean;
    private final CreateResponseGetItemDTOBean createResponseGetItemDTOBean;
    private final CreateResponseGetItemAllDTOBean createResponseGetItemAllDTOBean;

    public GetItemBean(GetItemEntityBean getItemEntityBean, CreateResponseGetItemDTOBean createResponseGetItemDTOBean, CreateResponseGetItemAllDTOBean createResponseGetItemAllDTOBean) {
        this.getItemEntityBean = getItemEntityBean;
        this.createResponseGetItemDTOBean = createResponseGetItemDTOBean;
        this.createResponseGetItemAllDTOBean = createResponseGetItemAllDTOBean;
    }

    public ResponseGetItemDTO exec(UUID itemId) {
        ItemEntity item = getItemEntityBean.exec(itemId);

        if (item == null) {
            throw new CustomException(ErrorCode.ITEM_NOT_FOUND);
        }

        return createResponseGetItemDTOBean.exec(item);
    }

    public List<ResponseGetItemAllDTO> exec(String category) {
        if("전체".equals(category)) {
            category = "all";
        }
       List<ItemEntity> itemList  = getItemEntityBean.exec(category);

        if(itemList.isEmpty()) {
            throw new CustomException(ErrorCode.ITEM_NOT_FOUND);
        }

        return itemList.stream().map(createResponseGetItemAllDTOBean::exec)
                .collect(Collectors.toList());
    }
}
