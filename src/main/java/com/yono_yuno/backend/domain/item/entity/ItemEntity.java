package com.yono_yuno.backend.domain.item.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@Entity
public class ItemEntity {
    @Id
    UUID itemId;
    String itemName;
    String brandName;
    int price;
    String itemImg;
    String contentImg;
    String category;
    double itemStars;
    int reviewNum;
    LocalDateTime createAt;
    LocalDateTime updateAt;
    int discount;

}

