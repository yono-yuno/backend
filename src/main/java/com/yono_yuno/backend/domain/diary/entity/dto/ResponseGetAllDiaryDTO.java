package com.yono_yuno.backend.domain.diary.entity.dto;

import com.yono_yuno.backend.domain.item.entity.dto.ItemInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseGetAllDiaryDTO {
    UUID diaryId;
    LocalDateTime createdAt;
    ItemInfoDTO itemInfo;
}
