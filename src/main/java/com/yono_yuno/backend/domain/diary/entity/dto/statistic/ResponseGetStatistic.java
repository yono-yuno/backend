package com.yono_yuno.backend.domain.diary.entity.dto.statistic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseGetStatistic {
    List<LineGraphData> lineGraphData;
    List<PieGraphData> pieGraphData;
}
