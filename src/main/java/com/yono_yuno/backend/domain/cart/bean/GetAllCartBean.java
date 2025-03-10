package com.yono_yuno.backend.domain.cart.bean;

import com.yono_yuno.backend.domain.cart.bean.small.CreateResponseGetAllCartDTOBean;
import com.yono_yuno.backend.domain.cart.bean.small.GetAllCartEntityBean;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseGetAllCartDTO;
import com.yono_yuno.backend.domain.user.bean.small.GetUserEntityBean;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

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
    public List<ResponseGetAllCartDTO> exec(UUID userId) {
        UserEntity user = getUserEntityBean.exec(userId);
        if (user == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        List<CartEntity> cartList = getAllCartEntityBean.exec(userId);

        return cartList.stream()
                .map(createResponseGetAllCartDTOBean::exec)
                .collect(Collectors.toList());
    }
}
