package com.yono_yuno.backend.domain.alarm.entity;

import com.yono_yuno.backend.domain.cart.entity.AskCount;
import com.yono_yuno.backend.global.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AlarmEntity extends BaseEntity {
    @Id
    UUID alarmId;
    UUID userId;
    UUID cartId;
    AskCount askCount;
    UUID diaryId;
    boolean isCheck;
}
