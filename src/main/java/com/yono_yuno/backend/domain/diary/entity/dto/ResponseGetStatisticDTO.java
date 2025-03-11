package com.yono_yuno.backend.domain.diary.entity.dto;

import com.yono_yuno.backend.domain.diary.entity.dto.statistic.LineGraphData;
import com.yono_yuno.backend.domain.diary.entity.dto.statistic.PieGraphData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseGetStatisticDTO {
    List<LineGraphData> lineGraphData;
    List<PieGraphData> pieGraphData;
}
