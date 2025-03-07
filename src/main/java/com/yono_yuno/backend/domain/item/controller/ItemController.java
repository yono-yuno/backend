package com.yono_yuno.backend.domain.item.controller;

import com.yono_yuno.backend.domain.item.entity.dto.ResponseGetItemAllDTO;
import com.yono_yuno.backend.domain.item.entity.dto.ResponseGetItemDTO;
import com.yono_yuno.backend.domain.item.service.ItemService;
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
@CrossOrigin("*")
@RequestMapping("/api/item")
@Tag(name = "상품 조회 API", description = "상품 조회 관련 API")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(summary = "상품 디테일 조회", description = "itemID로 해당 상품의 정보를 조회합니다.")
    @GetMapping()
    public ResponseEntity<Map<String, Object>> getItem(@RequestParam("itemId") UUID itemId) {
        ResponseGetItemDTO responseGetItemDTO = itemService.getItem(itemId);

        boolean success = responseGetItemDTO != null;

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "상품 조회 성공!" : "상품 조회 실패..");
        responseMap.put("itemInfo", responseGetItemDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }

    @Operation(summary = "상품 전체 조회", description = "category별 전체 상품의 정보를 조회합니다.")
    @GetMapping("/{category}")
    public ResponseEntity<Map<String, Object>> getAllItem(@PathVariable("category") String category, @RequestParam(value = "sort", required = false, defaultValue = "latest") String sort) {
        List<ResponseGetItemAllDTO> items = itemService.getAll(category, sort);
        boolean success = !items.isEmpty();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "상품 리스트 조회 성공!" : "상품 리스트 조회 실패..");
        responseMap.put("itemList", items);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }
}
