package com.yono_yuno.backend.domain.account.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountEntity {
    @Id
    UUID accountId;
    String accountNum;
    UUID userId;
    int balance;
}
