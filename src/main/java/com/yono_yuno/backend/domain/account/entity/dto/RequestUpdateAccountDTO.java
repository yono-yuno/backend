package com.yono_yuno.backend.domain.account.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RequestUpdateAccountDTO {
    UUID accountId;
    int balance;
}
