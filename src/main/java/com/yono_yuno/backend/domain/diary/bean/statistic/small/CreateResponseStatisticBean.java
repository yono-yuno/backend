package com.yono_yuno.backend.domain.diary.bean.statistic.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.GetItemInfo;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetAllDiaryDTO;
import com.yono_yuno.backend.domain.diary.entity.dto.statistic.LineGraphData;
import com.yono_yuno.backend.domain.diary.entity.dto.statistic.PieGraphData;
import com.yono_yuno.backend.domain.diary.entity.dto.statistic.ResponseGetStatistic;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CreateResponseStatisticBean {
    private final CreateResponseLineGraph createResponseLineGraph;
    private final CreateResponsePieGraph createResponsePieGraph;

    public CreateResponseStatisticBean(CreateResponseLineGraph createResponseLineGraph,CreateResponsePieGraph createResponsePieGraph){
        this.createResponseLineGraph=createResponseLineGraph;
        this.createResponsePieGraph=createResponsePieGraph;
    }
    public ResponseGetStatistic exec(List<DiaryEntity> current, List<DiaryEntity> prev){
        List<LineGraphData> line= createResponseLineGraph.exec(current,prev);
        if(line == null){
            throw new CustomException(ErrorCode.LINE_NOT_CREATE);
        }

        List<PieGraphData> pie=createResponsePieGraph.exec(current);
        if(pie == null){
            throw new CustomException(ErrorCode.PIE_NOT_CREATE);
        }
        return ResponseGetStatistic.builder()
                .lineGraphData(line)
                .pieGraphData(pie)
                .build();
    }
}
