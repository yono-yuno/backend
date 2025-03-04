package com.yono_yuno.backend.domain.cart.bean;

import com.yono_yuno.backend.domain.cart.bean.small.CreateCartDtoBean;
import com.yono_yuno.backend.domain.cart.bean.small.CreateCartEntityBean;
import com.yono_yuno.backend.domain.cart.bean.small.SaveCartEntityBean;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.entity.DTO.RequestCreateCartDTO;
import com.yono_yuno.backend.domain.cart.entity.DTO.ResponseCreateCartDTO;
import org.springframework.stereotype.Component;

@Component

public class CreateCartBean {
    //카트 정보 받아 오기
    //카트 정보 응답 보내기
    //카트 저장
    private final CreateCartDtoBean createCartDtoBean;
    private final CreateCartEntityBean createCartEntityBean;
    private final SaveCartEntityBean saveCartEntityBean;

    public CreateCartBean(CreateCartDtoBean createCartDtoBean, CreateCartEntityBean createCartEntityBean, SaveCartEntityBean saveCartEntityBean){
        this.createCartDtoBean = createCartDtoBean;
        this.createCartEntityBean=createCartEntityBean;
        this.saveCartEntityBean=saveCartEntityBean;
    }

    public ResponseCreateCartDTO exec(RequestCreateCartDTO requestCreateCartDTO){
        CartEntity cartEntity= createCartEntityBean.exec(requestCreateCartDTO);
        saveCartEntityBean.exec(cartEntity);
        return createCartDtoBean.exec(cartEntity);
    }
}
