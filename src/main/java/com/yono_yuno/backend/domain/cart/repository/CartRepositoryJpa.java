package com.yono_yuno.backend.domain.cart.repository;

import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CartRepositoryJpa extends JpaRepository<CartEntity, UUID>{
    CartEntity findByUserId(UUID userId);
    List<CartEntity> findAllByUserId(UUID userId);
}
