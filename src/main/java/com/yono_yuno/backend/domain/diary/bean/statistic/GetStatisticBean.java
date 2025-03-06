package com.yono_yuno.backend.domain.diary.bean.statistic;

import org.springframework.stereotype.Component;

@Component
public class GetStatisticBean {
    //일 단위 비교
        // 이번달 , 저번달 entity 가져오기
        //
        // 일에 맞게 매칭 후 반환 -> 응답 만들기로

    //카테 고리별 비교
        //이번달 entity 가져오기
        // 카테고리별 총 금액, 퍼센테이지 반환 -> 응답 만들기로

    // 다 해서 응답 만들기

    //currentList와 prevList에 들어있는 DiaryEntity들의 createAt을 갖고 와서 getDate를 통해 날짜가 일치한
    //diaryentity의 itemId를 가지고 itemdentity에서 price를 갖고와 야함

    //본문
    //userId와 yearMonth로 entity 가져와서 -> current는 now, prev는 now-1
    //변수명 = 바로 MonthStatistic으로 매개 변수 넣어주기 (CurrentMonthList<entity>, PrevMonthList<Entity>)

    //
}
