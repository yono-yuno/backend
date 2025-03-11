package com.yono_yuno.backend.domain.account.entity.dto;

import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class ResponseGetAccountDTO {
        UUID accountId;
        String accountNum;
        int balance;
}
