package com.yono_yuno.backend.domain.account.repository;

import com.yono_yuno.backend.domain.account.entity.AccountEntity;
import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccountRepositoryJPA extends JpaRepository<AccountEntity, UUID> {
    AccountEntity findByUserId(UUID userId);
}
