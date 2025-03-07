package com.yono_yuno.backend.domain.cart.repository;

import com.yono_yuno.backend.domain.cart.entity.AskCount;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface CartRepositoryJPA extends JpaRepository<CartEntity, UUID>{
    List<CartEntity> findAllByUserId(UUID userId);

    List<CartEntity> findAllByUserIdAndAskCount(UUID userId, AskCount askCount);
}
