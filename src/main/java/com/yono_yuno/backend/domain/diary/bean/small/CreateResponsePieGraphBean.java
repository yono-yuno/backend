package com.yono_yuno.backend.domain.diary.bean.small;

import com.yono_yuno.backend.domain.diary.bean.matching.CategoryMatching;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.entity.dto.statistic.PieGraphData;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CreateResponsePieGraphBean {
    private final CategoryMatching categoryMatching;

    public CreateResponsePieGraphBean(CategoryMatching categoryMatching){
        this.categoryMatching=categoryMatching;
    }

    public List<PieGraphData> exec(List<DiaryEntity> currents) {
        List<PieGraphData> pieGraphData = new ArrayList<>();
        Map<String, Integer> matching = categoryMatching.exec(currents);

        for (Map.Entry<String, Integer> entry : matching.entrySet()) {
            String category = entry.getKey();
            int price = entry.getValue();

            pieGraphData.add(new PieGraphData(category, price));
        }

        return pieGraphData;
    }
}
