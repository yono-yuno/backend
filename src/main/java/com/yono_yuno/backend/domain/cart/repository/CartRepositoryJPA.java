package com.yono_yuno.backend.domain.cart.repository;

import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CartRepositoryJPA extends JpaRepository<CartEntity, UUID>{
    List<CartEntity> findAllByUserId(UUID userId);
}
