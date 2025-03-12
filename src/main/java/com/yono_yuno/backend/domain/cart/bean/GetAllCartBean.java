package com.yono_yuno.backend.domain.cart.bean;

import com.yono_yuno.backend.domain.cart.bean.small.CreateResponseGetAllCartDTOBean;
import com.yono_yuno.backend.domain.cart.bean.small.GetAllCartEntityBean;
import com.yono_yuno.backend.domain.cart.entity.AskCount;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseGetAllCartDTO;
import com.yono_yuno.backend.domain.item.entity.dto.ResponseGetItemAllDTO;
import com.yono_yuno.backend.domain.user.bean.small.GetUserEntityBean;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Component
public class GetAllCartBean {
    private final GetUserEntityBean getUserEntityBean;
    private final GetAllCartEntityBean getAllCartEntityBean;
    private final CreateResponseGetAllCartDTOBean createResponseGetAllCartDTOBean;

    public GetAllCartBean(GetUserEntityBean getUserEntityBean, GetAllCartEntityBean getAllCartEntityBean, CreateResponseGetAllCartDTOBean createResponseGetAllCartDTOBean) {
        this.getUserEntityBean = getUserEntityBean;
        this.getAllCartEntityBean = getAllCartEntityBean;
        this.createResponseGetAllCartDTOBean = createResponseGetAllCartDTOBean;
    }
    public List<ResponseGetAllCartDTO> exec(UUID userId, String sort) {
        UserEntity user = getUserEntityBean.exec(userId);
        if (user == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        List<CartEntity> cartList = getAllCartEntityBean.exec(userId);
        List<ResponseGetAllCartDTO> cartSortList = cartList.stream()
                .filter(cart -> cart.getAskCount() == AskCount.FIRST_THINK || cart.getAskCount() == AskCount.SECOND_THINK)  // askCount가 0 또는 1인 것만 필터링
                .map(createResponseGetAllCartDTOBean::exec)
                .toList();

        if (sort != null) {
            switch (sort) {
                case "latest":
                    return cartSortList.stream()
                            .sorted(Comparator.comparing(
                                    ResponseGetAllCartDTO::getCreatedAt,
                                    Comparator.nullsLast(Comparator.naturalOrder()) // null 값을 마지막으로 정렬
                            ).reversed())
                            .collect(Collectors.toList());
                case "oldest":
                    return cartSortList.stream()
                            .sorted(Comparator.comparing(ResponseGetAllCartDTO::getCreatedAt))
                            .collect(Collectors.toList());
                case "highPrice":
                    return cartSortList.stream()
                            .sorted(Comparator.comparing(
                                    cart -> cart.getItemInfo().getPrice(),
                                    Comparator.reverseOrder()
                            ))
                            .collect(Collectors.toList());
                case "lowPrice":
                    return cartSortList.stream()
                            .sorted(Comparator.comparing(
                                    cart -> cart.getItemInfo().getPrice()))
                            .collect(Collectors.toList());
            }
        }
        return  cartSortList;
    }
}
