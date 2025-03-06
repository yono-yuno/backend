package com.yono_yuno.backend.domain.diary.repository;

import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.statistic.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemRepositoryJPA extends JpaRepository<ItemEntity, UUID> {
    Optional<List<ItemEntity>> findByCategory(String category);
    static ItemEntity findByItemId(UUID itemId);
}