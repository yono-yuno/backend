package com.yono_yuno.backend.domain.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserEntity {
    @Id
    UUID userId;
    String userName;
    String phoneNum;
    String passWord;
    int overPrice;
    String settingTime;
}
