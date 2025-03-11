package com.yono_yuno.backend.domain.cart.controller;

import com.yono_yuno.backend.domain.cart.entity.dto.*;
import com.yono_yuno.backend.domain.cart.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@Tag(name = "생각 중인 소비 API ", description = "생각중인 소비 관련 API")
@CrossOrigin("*")
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService=cartService;
    }

    @Operation(summary = "생각 중인 소비 생성", description = "생각 중인 소비목록에 상품을 넣습니다.")
    @PostMapping
    public ResponseEntity<Map<String, Object>> write(@RequestBody RequestCreateCartDTO requestCreateCartDTO) {
        ResponseCreateCartDTO responseCreateCartDTO = cartService.cartIn(requestCreateCartDTO);

        boolean success = responseCreateCartDTO != null;
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "생각 중인 소비목록에 넣기 성공" : "생각 중인 소비목록에 넣기 실패");

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }

    @Operation(summary = "생각 중인 상품 단일 조회", description = "생각 중인 상품들 중 하나를 조회합니다.")
    @GetMapping
    public ResponseEntity<Map<String, Object>> getCart(@RequestParam("cartId") UUID cartId) {
        ResponseGetCartDTO responseGetCartDTO = cartService.getCart(cartId);

        boolean success = responseGetCartDTO != null;
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "생각 중인 상품 단일 조회 성공" : "생각 중인 상품 단일 조회 실패");
        responseMap.put("cartInfo", responseGetCartDTO);

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    @Operation(summary = "생각 중인 소비의 상태 수정", description = "생각 중인 소비목록의 상품의 상태를 수정합니다.")
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateCart(@RequestBody RequestUpdateCartDTO requestUpdateCartDTO) {
        boolean success= cartService.updateCart(requestUpdateCartDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "생각 중인 소비 상태 수정 성공" : "생각 중인 소비 상태 수정 실패");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    @Operation(summary = "생각 중인 상품 목록 조회", description = "생각 중인 상품의 목록을 조회합니다.")
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllCart(@RequestParam("userId") UUID userId, @RequestParam(value = "sort", required = false, defaultValue = "latest") String sort) {
        List<ResponseGetAllCartDTO> cartList = cartService.getAllCart(userId, sort);

        boolean success = !cartList.isEmpty();
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "생각 중인 상품 목록 조회 성공" : "생각 중인 상품 목록 조회 실패");
        responseMap.put("cartList", cartList);

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }
}
