package com.yono_yuno.backend.domain.cart.bean;

import com.yono_yuno.backend.domain.cart.bean.small.CreateResponseGetAllCartDTOBean;
import com.yono_yuno.backend.domain.cart.bean.small.GetAllCartEntityBean;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseGetAllCartDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Component
public class GetAllCartBean {
    private final GetAllCartEntityBean getAllCartEntityBean;
    private final CreateResponseGetAllCartDTOBean createResponseGetAllCartDTOBean;

    public GetAllCartBean(GetAllCartEntityBean getAllCartEntityBean, CreateResponseGetAllCartDTOBean createResponseGetAllCartDTOBean){
        this.getAllCartEntityBean=getAllCartEntityBean;
        this.createResponseGetAllCartDTOBean=createResponseGetAllCartDTOBean;
    }
    public List<ResponseGetAllCartDTO> exec(UUID userId){
        List<CartEntity> cartList=getAllCartEntityBean.exec(userId);

        return cartList.stream()
                .map(createResponseGetAllCartDTOBean::exec)
                .collect(Collectors.toList());
    }
}
