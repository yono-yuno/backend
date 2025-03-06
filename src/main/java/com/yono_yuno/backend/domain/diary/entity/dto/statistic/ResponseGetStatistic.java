package com.yono_yuno.backend.domain.diary.entity.dto.statistic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseGetStatistic {
    LineGraphData lineGraphData;
    PieGraphData pieGraphData;
}
