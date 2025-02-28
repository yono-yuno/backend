package com.yono_yuno.backend.domain.user.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestSignUpDTO {
    String userName;
    String phoneNum;
    String accountNum;
    String passWord;
}
