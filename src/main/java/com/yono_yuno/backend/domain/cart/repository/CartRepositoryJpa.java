package com.yono_yuno.backend.domain.cart.repository;

import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartRepositoryJpa extends JpaRepository<CartEntity, UUID>{
}
