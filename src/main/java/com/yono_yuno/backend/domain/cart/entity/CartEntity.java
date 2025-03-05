package com.yono_yuno.backend.domain.cart.entity;

import com.yono_yuno.backend.global.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartEntity extends BaseEntity {
    @Id
    UUID cartId;
    UUID itemId;
    int askCount;
    UUID userId;
}
