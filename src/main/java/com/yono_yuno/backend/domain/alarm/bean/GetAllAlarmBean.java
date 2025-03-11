package com.yono_yuno.backend.domain.alarm.bean;

import com.yono_yuno.backend.domain.alarm.bean.small.*;
import com.yono_yuno.backend.domain.alarm.entity.AlarmEntity;
import com.yono_yuno.backend.domain.alarm.entity.dto.ResponseGetAllAlarmDTO;
import com.yono_yuno.backend.domain.cart.bean.small.CalculationExtraTime;
import com.yono_yuno.backend.domain.cart.bean.small.GetAllCartEntityBean;
import com.yono_yuno.backend.domain.cart.entity.AskCount;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.diary.bean.small.GetAllDiaryEntityBean;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.user.bean.small.GetUserEntityBean;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.global.error.CustomException;
import com.yono_yuno.backend.global.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class GetAllAlarmBean {
    private final GetUserEntityBean getUserEntityBean;
    private final GetAllCartEntityBean getAllCartEntityBean;
    private final CalculationExtraTime calculationExtraTime;
    private final GetAlarmEntityBean getAlarmEntityBean;
    private final CreateAlarmEntityBean createAlarmEntityBean;
    private final SaveAlarmEntityBean saveAlarmEntityBean;
    private final GetAllDiaryEntityBean getAllDiaryEntityBean;
    private final GetAllAlarmEntityBean getAllAlarmEntityBean;
    private final CreateResponseGetAllAlarmDTOBean createResponseGetAllAlarmDTOBean;

    public GetAllAlarmBean(GetUserEntityBean getUserEntityBean,
                           GetAllCartEntityBean getAllCartEntityBean,
                           CalculationExtraTime calculationExtraTime,
                           GetAlarmEntityBean getAlarmEntityBean,
                           CreateAlarmEntityBean createAlarmEntityBean,
                           SaveAlarmEntityBean saveAlarmEntityBean,
                           GetAllDiaryEntityBean getAllDiaryEntityBean,
                           GetAllAlarmEntityBean getAllAlarmEntityBean,
                           CreateResponseGetAllAlarmDTOBean createResponseGetAllAlarmDTOBean) {
        this.getUserEntityBean = getUserEntityBean;
        this.getAllCartEntityBean = getAllCartEntityBean;
        this.calculationExtraTime = calculationExtraTime;
        this.getAlarmEntityBean = getAlarmEntityBean;
        this.createAlarmEntityBean = createAlarmEntityBean;
        this.saveAlarmEntityBean = saveAlarmEntityBean;
        this.getAllDiaryEntityBean = getAllDiaryEntityBean;
        this.getAllAlarmEntityBean = getAllAlarmEntityBean;
        this.createResponseGetAllAlarmDTOBean = createResponseGetAllAlarmDTOBean;
    }

    public List<ResponseGetAllAlarmDTO> exec(UUID userId) {
        UserEntity user = getUserEntityBean.exec(userId);

        // 유저가 존재하지 않을 경우 에러 처리
        if (user == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        // 고민시간 알람 설정
        List<CartEntity> cartEntityList = getAllCartEntityBean.exec(userId, AskCount.FIRST_THINK);
        cartEntityList.addAll(getAllCartEntityBean.exec(userId, AskCount.SECOND_THINK));
        cartEntityList.removeIf(cart -> {
            // 아직 고민시간이 끝나지 않았을 경우 제거
            if (!calculationExtraTime.exec(userId, cart).equals("00-00-00")) {
                return true;
            }

            AlarmEntity alarm = getAlarmEntityBean.exec(userId, cart.getCartId(), cart.getAskCount());

            // 아직 생성되지 않은 알람일 경우 알람 생성
            if (alarm == null) {
                AlarmEntity alarmEntity = createAlarmEntityBean.exec(userId, cart.getCartId(), cart.getAskCount(), null);
                saveAlarmEntityBean.exec(alarmEntity);
                return false;
            }

            // 이미 생성됐으며 확인된 알람일 경우 제거
            return alarm.isCheck();
        });

        // 리뷰를 작성할 시간이 됐을 경우

        // 구매한지 3일 뒤에 알림이 뜨도록 설정
        // List<DiaryEntity> diaryEntityList = getAllDiaryEntityBean.exec(userId, LocalDateTime.now().minusDays(3));

        // 테스트를 위해 1분으로 설정
        List<DiaryEntity> diaryEntityList = getAllDiaryEntityBean.exec(userId, LocalDateTime.now().minusMinutes(1));

        diaryEntityList.removeIf(diary -> {
            AlarmEntity alarm = getAlarmEntityBean.exec(userId, diary.getDiaryId());

            // 아직 생성되지 않은 알람일 경우 알람 생성
            if (alarm == null) {
                AlarmEntity alarmEntity = createAlarmEntityBean.exec(userId, null, null, diary.getDiaryId());
                saveAlarmEntityBean.exec(alarmEntity);
                return false;
            }

            // 이미 생성됐으며 확인된 알람일 경우 제거
            return alarm.isCheck();
        });

        // 확인하지 않은 알람들 가져오기
        List<AlarmEntity> alarmEntityList = getAllAlarmEntityBean.exec(userId);

        return alarmEntityList.stream()
                .map(createResponseGetAllAlarmDTOBean::exec)
                .collect(Collectors.toList());
    }
}
