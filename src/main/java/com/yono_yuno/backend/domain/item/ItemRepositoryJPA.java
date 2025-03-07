package com.yono_yuno.backend.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemRepositoryJPA extends JpaRepository<ItemEntity, UUID> {
    Optional<List<ItemEntity>> findByCategory(String category);
    ItemEntity findByItemId(UUID itemId);
}
