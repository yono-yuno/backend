package com.yono_yuno.backend.domain.diary.entity.dto.statistic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LineGraphData {
    int day;
    int prev;
    int curr;
    boolean weekData;
}
