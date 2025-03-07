package com.yono_yuno.backend.domain.item;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemEntity {
    @Id
    UUID itemId;
    int price;
    String category;

}
