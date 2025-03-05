package com.yono_yuno.backend.domain.cart.controller;

import com.yono_yuno.backend.domain.cart.entity.dto.RequestCreateCartDTO;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseCreateCartDTO;
import com.yono_yuno.backend.domain.cart.entity.dto.ResponseGetCartDTO;
import com.yono_yuno.backend.domain.cart.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@Tag(name = "생각 중인 소비 API ", description = "생각중인 소비 관련 API")
@CrossOrigin("*")
@RequestMapping("/api/cart")

public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService){
        this.cartService=cartService;
    }

    @Operation(summary = "카트 인", description = "카트에 상품을 넣습니다.")
    @PostMapping()
    public ResponseEntity<Map<String, Object>> write(@RequestBody RequestCreateCartDTO requestCreateCartDTO) {
        ResponseCreateCartDTO responseCreateCartDTO = cartService.cartIn(requestCreateCartDTO);

        boolean success = responseCreateCartDTO != null;
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", success);
        responseMap.put("message", success ? "생각중인 소비 넣기 성공" : "생각중인 소비 넣기 실패");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }
}
