package com.yono_yuno.backend.domain.item.repository;

import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepositoryJPA extends JpaRepository<ItemEntity, UUID>{
}
