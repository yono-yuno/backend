package com.yono_yuno.backend.domain.cart.bean;

import com.yono_yuno.backend.domain.cart.bean.small.CreateCartDTOBean;
import com.yono_yuno.backend.domain.cart.bean.small.CreateCartEntityBean;
import com.yono_yuno.backend.domain.cart.bean.small.SaveCartEntityBean;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.entity.dto.RequestCreateCartDTO;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseCreateCartDTO;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

@Component

public class CreateCartBean {
    //카트 ID 생성, 요청에서 정보 갖고오기
    //카트 정보 저장
    //카트 정보 보내기
    private final CreateCartEntityBean createCartEntityBean;
    private final SaveCartEntityBean saveCartEntityBean;
    private final CreateCartDTOBean createCartDtoBean;


    public CreateCartBean(CreateCartEntityBean createCartEntityBean,SaveCartEntityBean saveCartEntityBean, CreateCartDTOBean createCartDtoBean){
        this.createCartEntityBean=createCartEntityBean;
        this.saveCartEntityBean=saveCartEntityBean;
        this.createCartDtoBean = createCartDtoBean;
    }

    public ResponseCreateCartDTO exec(RequestCreateCartDTO requestCreateCartDTO){
        if (requestCreateCartDTO.getUserId() == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }
        if (requestCreateCartDTO.getItemId() == null) {
            throw new CustomException(ErrorCode.ITEM_NOT_FOUND);
        }

        CartEntity cartEntity= createCartEntityBean.exec(requestCreateCartDTO);

        if (cartEntity == null){
            throw new CustomException(ErrorCode.CART_NOT_IN);
        }

        saveCartEntityBean.exec(cartEntity);
        return createCartDtoBean.exec(cartEntity);
    }
}
