package com.yono_yuno.backend.global;

import com.yono_yuno.backend.domain.account.entity.AccountEntity;
import com.yono_yuno.backend.domain.account.repository.AccountRepositoryJPA;
import com.yono_yuno.backend.domain.alarm.entity.AlarmEntity;
import com.yono_yuno.backend.domain.alarm.repository.AlarmRepositoryJPA;
import com.yono_yuno.backend.domain.cart.entity.AskCount;
import com.yono_yuno.backend.domain.cart.entity.CartEntity;
import com.yono_yuno.backend.domain.cart.repository.CartRepositoryJPA;
import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.repository.DiaryRepositoryJPA;
import com.yono_yuno.backend.domain.item.entity.ItemEntity;
import com.yono_yuno.backend.domain.item.repository.ItemRepositoryJPA;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.domain.user.repository.UserRepositoryJPA;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserRepositoryJPA userRepositoryJPA;
    private final DiaryRepositoryJPA diaryRepositoryJPA;
    private final CartRepositoryJPA cartRepositoryJPA;
    private final AlarmRepositoryJPA alarmRepositoryJPA;
    private final ItemRepositoryJPA itemRepositoryJPA;
    private final AccountRepositoryJPA accountRepositoryJPA;

    public DataLoader(UserRepositoryJPA userRepositoryJPA, DiaryRepositoryJPA diaryRepositoryJPA, CartRepositoryJPA cartRepositoryJPA, AlarmRepositoryJPA alarmRepositoryJPA, ItemRepositoryJPA itemRepositoryJPA, AccountRepositoryJPA accountRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.diaryRepositoryJPA = diaryRepositoryJPA;
        this.cartRepositoryJPA = cartRepositoryJPA;
        this.alarmRepositoryJPA = alarmRepositoryJPA;
        this.itemRepositoryJPA = itemRepositoryJPA;
        this.accountRepositoryJPA = accountRepositoryJPA;
    }

    @Override
    public void run(String... args) throws Exception {
        // 유저 데이터
        UserEntity user = UserEntity.builder()
                .userId(UUID.randomUUID())
                .userName("홍길동")
                .phoneNum("01011112222")
                .passWord("123123")
                .overPrice(10000)
                .settingTime("0100")
                .build();

        userRepositoryJPA.save(user);

        // ---------------------------------------------------------------------
        // 계좌 데이터
        AccountEntity account = AccountEntity.builder()
                .accountId(UUID.randomUUID())
                .accountNum("123412341234")
                .balance(0)
                .userId(user.getUserId())
                .build();

        accountRepositoryJPA.save(account);

        // ---------------------------------------------------------------------
        // 상품 데이터
        // 식품
        ItemEntity item1 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("쿡솜씨")
                .itemName("쿡솜씨 우삼겹숙주볶음 밀키트 2인분")
                .price(11040)
                .discount(20)
                .itemStars(4.5)
                .reviewNum(1407)
                .category("식품")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/dl/v2/7/7/1/0/8/2/igcNN/3491771082_196446370.jpg")
                .contentImg("https://gi.esmplus.com/somssi53/_banner/KakaoTalk_20241219_112846805.jpg")
                .build();

        itemRepositoryJPA.save(item1);

        ItemEntity item2 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("한우 고집쟁이")
                .itemName("1등급 숙성한우 암소 채끝 한근 300g+300g")
                .price(52400)
                .discount(10)
                .itemStars(4.5)
                .reviewNum(3)
                .category("식품")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/7520996787/B.jpg?78000000")
                .contentImg("https://jacksonkorea.speedgabia.com/93_hanwoo/timon/sukcheaend/p1.jpg?v=1")
                .build();

        itemRepositoryJPA.save(item2);

        ItemEntity item3 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("아워홈")
                .itemName("온더고 함박스테이크정식 290g, 2개 + 통모짜치즈 불닭 290g, 2개 + 숯불향 데리야끼 소불고기 덮밥 290g, 2개 + 로제파스타 미니함박 310g, 2개")
                .price(31900)
                .discount(29)
                .itemStars(5.0)
                .reviewNum(3302)
                .category("식품")
                .itemImg("https://cdn.011st.com/11dims/resize/1000x1000/quality/75/11src/product/6594304590/B.jpg?671000000")
                .contentImg("https://store.img11.co.kr/68636870/bbd35df0-68c6-462f-a9ba-03225c11a8a2_1694581726169.jpg")
                .build();

        itemRepositoryJPA.save(item3);

        // 패션 잡화
        ItemEntity item4 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("미나티")
                .itemName("미나티 드리핑백 루즈 숄더 빅사이즈 데일리 보부상가방 호보백 E20")
                .price(20500)
                .discount(4)
                .itemStars(4.3)
                .reviewNum(9175)
                .category("패션잡화")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/6147351202/B.jpg?178000000")
                .contentImg("https://ai.esmplus.com/woowaausa/E/E20/E20.jpg")
                .build();

        itemRepositoryJPA.save(item4);

        ItemEntity item5 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("락포트")
                .itemName("[락포트 정품] truTECH + 오너먼트 소가죽 로퍼")
                .price(164680)
                .discount(8)
                .itemStars(4.5)
                .reviewNum(9999)
                .category("패션잡화")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/pd/v2/9/0/4/2/1/5/VfVlK/7941904215_B.jpg")
                .contentImg("https://image.cjonstyle.net/cjupload/htmledit/ven_img/561344/락포트_25SS_로퍼_남/brown-1.png")
                .build();

        itemRepositoryJPA.save(item5);

        ItemEntity item6 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("애스 모던즈")
                .itemName("워치 와인더 오토매틱 시계 와인딩 보관함 오토메틱 관리 1구 2구 4구")
                .price(43900)
                .discount(10)
                .itemStars(4.5)
                .reviewNum(11)
                .category("패션잡화")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/6268107915/B.jpg?578000000")
                .contentImg("https://cdn.011st.com/11dims/thumbnail/11src/editorImg/20240517/73625326/1715930971273_E.jpg")
                .build();

        itemRepositoryJPA.save(item6);

        // 전자제품
        ItemEntity item7 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("LEZEN")
                .itemName("르젠 대용량 가열식 가습기 LZHD-900Y")
                .price(10900)
                .discount(5)
                .itemStars(4.8)
                .reviewNum(213)
                .category("전자제품")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/pd/v2/5/6/9/5/0/3/nPTVa/6762569503_B.jpg")
                .contentImg("https://gi.esmplus.com/zenshopg/openmarket/wadiz/lzhd900y_42.jpg")
                .build();

        itemRepositoryJPA.save(item7);

        ItemEntity item8 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("아쿠아픽")
                .itemName("아쿠아픽 AQ-230 휴대용 구강세정기 무선 구강세척기 물치실 국내 대한치과의사협회 공식추천품")
                .price(75000)
                .discount(6)
                .itemStars(4.5)
                .reviewNum(295)
                .category("전자제품")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/2562376795/B.jpg?584000000")
                .contentImg("https://gi.esmplus.com/socialkr/%EC%95%84%EC%BF%A0%EC%95%84%ED%94%BD/AQ-230/01%20AQ-230_%ED%8C%90%EB%A7%A4%EC%88%98%EB%9F%89%20%EB%B0%B0%EB%84%88%20%EC%9D%B4%EB%AF%B8%EC%A7%80.jpg")
                .build();

        itemRepositoryJPA.save(item8);

        ItemEntity item9 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("ACEONE")
                .itemName("에이스원 R1 레트로 디지털카메라 똑딱이 소형 미니 빈티지 디카")
                .price(166000)
                .discount(1)
                .itemStars(4.5)
                .reviewNum(71)
                .category("전자제품")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/6914652975/B.jpg?384000000")
                .contentImg("https://ai.esmplus.com/aceonekorea/R1%20%EB%94%94%EC%B9%B4/r1_15.jpg")
                .build();

        itemRepositoryJPA.save(item9);

        // 출산 · 육아
        ItemEntity item10 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("하기스")
                .itemName("하기스 물놀이팬티 5단계 공용 12입 1개 물놀이기저귀 아기방수기저귀")
                .price(18500)
                .discount(2)
                .itemStars(4.9)
                .reviewNum(51)
                .category("출산 · 육아")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/7389690747/B.png?589000000")
                .contentImg("https://d1spxp74pmd23j.cloudfront.net/A00869393/cloud/29348.png")
                .build();

        itemRepositoryJPA.save(item10);

        ItemEntity item11 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("헬로카봇")
                .itemName("헬로카봇 제트 크루저")
                .price(86000)
                .discount(5)
                .itemStars(5.0)
                .reviewNum(1557)
                .category("출산 · 육아")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/5184793113/B.jpg?40000000")
                .contentImg("https://ai.esmplus.com/asdflkjh0230/SONOGONG/carbot/carbot_JetCruiser.jpg")
                .build();

        itemRepositoryJPA.save(item11);

        ItemEntity item12 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("셀러허브")
                .itemName("[JHQRMYQK_4B]플리스 후리스 점퍼 키즈바람막이")
                .price(54120)
                .discount(5)
                .itemStars(4.7)
                .reviewNum(946)
                .category("출산 · 육아")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/8054061856/B.jpg?968341338")
                .contentImg("https://store.img11.co.kr/11365421/05bf6000-d796-4c15-905c-1e63a523a3da_1697419238235.jpg")
                .build();

        itemRepositoryJPA.save(item12);

        // ---------------------------------------------------------------------
        // 고민 중인 상품 데이터
        CartEntity cart1 = CartEntity.builder()
                .cartId(UUID.randomUUID())
                .itemId(item4.getItemId())
                .askCount(AskCount.FIRST_THINK)
                .build();

        cartRepositoryJPA.save(cart1);

        // ---------------------------------------------------------------------
        // 결제 내역 데이터
        DiaryEntity diary1 = DiaryEntity.builder()
                .diaryId(UUID.randomUUID())
                .userId(user.getUserId())
                .firstReview("맛있어보여서 샀는데 너무 기대 중!")
                .consumerStars(4.0)
                .detailDiary("맛도 있고 가격도 괜찮은 가성비 아이템 찾은 것 같다!")
                .itemId(item1.getItemId())
                .build();

        diaryRepositoryJPA.save(diary1);

        DiaryEntity diary2 = DiaryEntity.builder()
                .diaryId(UUID.randomUUID())
                .userId(user.getUserId())
                .firstReview("가방이 너무 예뻐보였다..")
                .consumerStars(3.0)
                .detailDiary("재질이나 색상은 원하는 느낌이었지만 마감처리가 살짝 아쉬웠다.")
                .itemId(item4.getItemId())
                .build();

        diaryRepositoryJPA.save(diary2);

        DiaryEntity diary3 = DiaryEntity.builder()
                .diaryId(UUID.randomUUID())
                .userId(user.getUserId())
                .firstReview("너무 건조한 것 같아서 샀다.")
                .consumerStars(5.0)
                .detailDiary("건조함이 사라지고 촉촉함만 남았다. 잘 산 것 같다.")
                .itemId(item7.getItemId())
                .build();

        diaryRepositoryJPA.save(diary3);

        DiaryEntity diary4 = DiaryEntity.builder()
                .diaryId(UUID.randomUUID())
                .userId(user.getUserId())
                .firstReview("고기가 먹고 싶어서 구매했다.")
                .itemId(item2.getItemId())
                .build();

        diaryRepositoryJPA.save(diary4);

        DiaryEntity diary5 = DiaryEntity.builder()
                .diaryId(UUID.randomUUID())
                .userId(user.getUserId())
                .firstReview("회사 면접을 앞두고 신발을 구매했다.")
                .itemId(item5.getItemId())
                .build();

        diaryRepositoryJPA.save(diary5);

        DiaryEntity diary6 = DiaryEntity.builder()
                .diaryId(UUID.randomUUID())
                .userId(user.getUserId())
                .firstReview("환절기 입냄새 방지를 위해 후기가 좋은 제품으로 사봤다.")
                .itemId(item8.getItemId())
                .build();

        diaryRepositoryJPA.save(diary6);

        // ---------------------------------------------------------------------
        // 알람 내역 데이터
        AlarmEntity alarm1 = AlarmEntity.builder()
                .alarmId(UUID.randomUUID())
                .userId(user.getUserId())
                .cartId(null)
                .askCount(null)
                .diaryId(diary4.getDiaryId())
                .isCheck(false)
                .build();

        alarmRepositoryJPA.save(alarm1);

        AlarmEntity alarm2 = AlarmEntity.builder()
                .alarmId(UUID.randomUUID())
                .userId(user.getUserId())
                .cartId(cart1.getCartId())
                .askCount(cart1.getAskCount())
                .diaryId(null)
                .isCheck(false)
                .build();

        alarmRepositoryJPA.save(alarm2);
    }
}
