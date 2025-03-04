package com.yono_yuno.backend.domain.user.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestLoginDTO {
    String phoneNum;
    String passWord;
}
