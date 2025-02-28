package com.yono_yuno.backend.domain.account.repository;

import com.yono_yuno.backend.domain.account.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepositoryJPA extends JpaRepository<AccountEntity, UUID> {
}
