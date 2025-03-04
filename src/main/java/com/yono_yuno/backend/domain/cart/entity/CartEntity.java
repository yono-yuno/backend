package com.yono_yuno.backend.domain.cart.entity;

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
public class CartEntity {
    @Id
    UUID cartId;
    UUID itemId;
    int askCount;
    UUID userId;
}
