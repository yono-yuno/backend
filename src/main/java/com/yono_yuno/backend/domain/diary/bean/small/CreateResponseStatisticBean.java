package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.statistic.LineGraphData;
import com.yono_yuno.backend.domain.diary.entity.dto.statistic.PieGraphData;
import com.yono_yuno.backend.domain.diary.entity.dto.ResponseGetStatisticDTO;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateResponseStatisticBean {
    private final CreateResponseLineGraphBean createResponseLineGraphBean;
    private final CreateResponsePieGraphBean createResponsePieGraphBean;

    public CreateResponseStatisticBean(CreateResponseLineGraphBean createResponseLineGraphBean, CreateResponsePieGraphBean createResponsePieGraphBean) {
        this.createResponseLineGraphBean = createResponseLineGraphBean;
        this.createResponsePieGraphBean = createResponsePieGraphBean;
    }

    public ResponseGetStatisticDTO exec(List<DiaryEntity> current, List<DiaryEntity> prev) {
        List<LineGraphData> line = createResponseLineGraphBean.exec(current, prev);
        if (line == null) {
            throw new CustomException(ErrorCode.LINE_NOT_CREATE);
        }

        List<PieGraphData> pie = createResponsePieGraphBean.exec(current);
        if (pie == null) {
            throw new CustomException(ErrorCode.PIE_NOT_CREATE);
        }

        return ResponseGetStatisticDTO.builder()
                .lineGraphData(line)
                .pieGraphData(pie)
                .build();
    }
}
