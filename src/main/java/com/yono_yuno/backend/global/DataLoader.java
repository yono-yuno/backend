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

        // 생활
        ItemEntity item13 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("SINGER")
                .itemName("[싱거미싱] 가정용 미싱 싱거 M2105 / 어린이도 안전한 재봉틀 / 본품+프리미엄매트")
                .price(216540)
                .discount(1)
                .itemStars(4.6)
                .reviewNum(66)
                .category("생활")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/1231798782/B.jpg?152000000")
                .contentImg("https://ai.esmplus.com/taeyangsm/singer/product2020/mseries/m2105/0201-head.jpg")
                .build();

        itemRepositoryJPA.save(item13);

        ItemEntity item14 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("스타비데")
                .itemName("스타비데 직수형 방수비데 MB-ipx5등급 최신출시 필터가필요없는직수방수 모델(설치비 별도)")
                .price(13800)
                .discount(10)
                .itemStars(4.7)
                .reviewNum(110)
                .category("생활")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/4560598623/B.jpg?263000000")
                .contentImg("https://gi.esmplus.com/thesubath/MB-ipx5/MB-ipx5.jpg")
                .build();

        itemRepositoryJPA.save(item14);

        ItemEntity item15 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("오후엔")
                .itemName("오후엔 세탁소용 보풀제거기 OF-4000")
                .price(29000)
                .discount(5)
                .itemStars(5.0)
                .reviewNum(56)
                .category("생활")
                .itemImg("https://cdn.011st.com/11dims/resize/1000x1000/quality/75/11src/product/7692620244/B.jpg?820000000")
                .contentImg("https://store.img11.co.kr/68636870/cc8bcb6f-54cd-4913-8c1d-64a234eccce8_1729840593382.jpg")
                .build();

        itemRepositoryJPA.save(item15);

        // 뷰티
        ItemEntity item16 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("이자녹스")
                .itemName("초초초특가! 이자녹스 셀리뉴 컨실링 쿠션 본품2+리필2+퍼프3")
                .price(30860)
                .discount(20)
                .itemStars(4.6)
                .reviewNum(89)
                .category("뷰티")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/7743380418/B.jpg?582624392")
                .contentImg("https://shfile.kshop.co.kr/d2/bo/common/editor/202410/24/1024192bdba5152.jpg")
                .build();

        itemRepositoryJPA.save(item16);

        ItemEntity item17 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("디올")
                .itemName("소바쥬 오 드 퍼퓸 EDP 100ML")
                .price(131740)
                .discount(2)
                .itemStars(5.0)
                .reviewNum(2)
                .category("뷰티")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/7420329247/B.jpg?375000000")
                .contentImg("https://i.sellerhub.shop/v1/detail/411d590342be8075818149505822f166f53719b1.jpg")
                .build();

        itemRepositoryJPA.save(item17);

        ItemEntity item18 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("보스티나")
                .itemName("보스티나 더플러스 본품 12개+앰플 20매+꼬리빗 5개")
                .price(66170)
                .discount(17)
                .itemStars(4.6)
                .reviewNum(13)
                .category("뷰티")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/7666246643/B.jpg?478254715")
                .contentImg("https://image.nsmall.com/ec_descimages/2/23/02/7845715426088835.jpg")
                .build();

        itemRepositoryJPA.save(item18);

        // 의류
        ItemEntity item19 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("까사렐")
                .itemName("[3만원인하] 까사렐 25PRE-SPRING 레이스포인트 니트 4종")
                .price(43620)
                .discount(12)
                .itemStars(4.8)
                .reviewNum(74)
                .category("의류")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/pd/v2/8/2/8/2/3/9/yyEKG/8011828239_B.jpg")
                .contentImg("https://image.cjonstyle.net/cjupload/htmledit/ven_img/543401/24FW_LACE/cacharel_laceknit_05.jpg")
                .build();

        itemRepositoryJPA.save(item19);

        ItemEntity item20 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("고비")
                .itemName("[런칭가 1990000원]고비(GOBI) 캐시미어 100 헤리티지 우븐 롱코트")
                .price(1462800)
                .discount(8)
                .itemStars(5.0)
                .reviewNum(9999)
                .category("의류")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/7358209000/B.jpg?48425506")
                .contentImg("https://image.hmall.com/CO/EDITOR/20241010/172900597/20241010_172900597_54814.jpg")
                .build();

        itemRepositoryJPA.save(item20);

        ItemEntity item21 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("블루핏")
                .itemName("블루핏 이태리 스웨이드 자켓 (남성)")
                .price(383900)
                .discount(14)
                .itemStars(4.8)
                .reviewNum(921)
                .category("의류")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/6244474580/B.jpg?632089482")
                .contentImg("https://img.shinsegaetvshopping.com/htmleditor/763/SSG-%EB%B8%94%EB%A3%A8%ED%95%8F-%EC%8A%A4%EC%9B%A8%EC%9D%B4%EB%93%9C-%EC%9E%90%EC%BC%93_%EB%82%A8%EC%84%B1-011694498768842.jpg")
                .build();

        itemRepositoryJPA.save(item21);

        // 여행 · 취미
        ItemEntity item22 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("종이비행기투어")
                .itemName("해비치호텔앤리조트 (제주도호텔/호텔예약/리조트/제주여행)")
                .price(168500)
                .discount(5)
                .itemStars(5.0)
                .reviewNum(31)
                .category("여행 · 취미")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/dl/v2/2/6/2/7/7/9/bcnba/6985262779_196082657.jpg")
                .contentImg("https://ai.esmplus.com/airjonge4/haevichi/promo/250227/havichi_01.jpg")
                .build();

        itemRepositoryJPA.save(item22);

        ItemEntity item23 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("숙박페스타")
                .itemName("[숙박페스타]오크밸리리조트 룸온리 or 객실+뮤지엄산티켓2인")
                .price(111500)
                .discount(5)
                .itemStars(4.7)
                .reviewNum(199)
                .category("여행 · 취미")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/dl/v2/6/2/0/1/0/6/ySNnl/7489620106_196620001.jpg")
                .contentImg("https://ai.esmplus.com/airjonge4/oakvalley/promo/250310/oak_01.jpg")
                .build();

        itemRepositoryJPA.save(item23);

        ItemEntity item24 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("J2K")
                .itemName("해외전투 핀볼 게임 보드 게임기")
                .price(38000)
                .discount(56)
                .itemStars(4.1)
                .reviewNum(10)
                .category("여행 · 취미")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/dl/v2/0/2/3/8/9/2/IDzmr/7194023892_196547574.jpg")
                .contentImg("https://cdn.heyseller.kr/images/14e5dd7a-22ec-4984-93ff-b6f2b252ec71.png")
                .build();

        itemRepositoryJPA.save(item24);

        // 스포츠
        ItemEntity item25 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("스케쳐스")
                .itemName("[스케쳐스]*공식판매처* 25S/S 남여 성인 발편한 워킹화/런닝화/운동화 모음전")
                .price(89000)
                .discount(5)
                .itemStars(4.8)
                .reviewNum(89)
                .category("스포츠")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/dl/v2/2/7/0/3/2/1/HLWEF/7792270321_196314943.jpg")
                .contentImg("https://cdn.011st.com/11dims/quality/75/11src/http://www.image.hahamall.net/~image/11st/250202/0217_SKE_bundle_67/A.jpg")
                .build();

        itemRepositoryJPA.save(item25);

        ItemEntity item26 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("JEEP")
                .itemName("JEEP 방수점퍼 바람막이 후드집업 등산자켓 남녀공용 아웃도어 후리스자켓")
                .price(65000)
                .discount(2)
                .itemStars(4.9)
                .reviewNum(320)
                .category("스포츠")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/dl/v2/3/5/1/3/8/1/rseLK/7998351381_196152128.jpg")
                .contentImg("https://media-cdn.windly.cc/3f/19/d-3f19e3aa-ff4c-41e3-9fa0-97c383577e76/_w_758/_ma_1/_q_94/_ros_1.jpg")
                .build();

        itemRepositoryJPA.save(item26);

        ItemEntity item27 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("노스페이스")
                .itemName("[노스페이스 본사 공식] S/S 신규 자켓/맨투맨/백팩/슈즈 등 모음")
                .price(38000)
                .discount(5)
                .itemStars(4.7)
                .reviewNum(3936)
                .category("스포츠")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/2549441617/B.jpg?555721196")
                .contentImg("https://cdn.011st.com/11dims/quality/75/11src/http://www.image.hahamall.net/~image/11st/250302/0307_NF_SS_100/A15.jpg")
                .build();

        itemRepositoryJPA.save(item27);

        // 도서
        ItemEntity item28 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("쌤앤파커스")
                .itemName("삶이라는 완벽한 농담 /이경규 에세이")
                .price(16020)
                .discount(10)
                .itemStars(5.0)
                .reviewNum(4)
                .category("도서")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/dl/v2/9/2/0/9/4/3/kYYFL/8029920943_196441740.jpg")
                .contentImg("https://image.yes24.com/momo/TopCate5163/MidCate003/516220692(1).jpg")
                .build();

        itemRepositoryJPA.save(item28);

        ItemEntity item29 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("눈높이")
                .itemName("눈높이영어 (3개월) - 영어실력 완성 프로그램")
                .price(79200)
                .discount(20)
                .itemStars(5.0)
                .reviewNum(86)
                .category("도서")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/dl/v2/5/8/1/9/8/8/rzYBg/2344581988_195944705.jpg")
                .contentImg("https://ai.esmplus.com/daekyomall/2024/eng/eng_01s.jpg")
                .build();

        itemRepositoryJPA.save(item29);

        ItemEntity item30 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("황우도서출판")
                .itemName("[황우도서출판] 인물로 배우는 어린이 인성인문학 (50권 세트)")
                .price(30600)
                .discount(18)
                .itemStars(4.6)
                .reviewNum(71)
                .category("도서")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/dl/v2/8/4/5/1/1/9/xRiys/6825845119_196343679.jpg")
                .contentImg("https://cdn.011st.com/11dims/thumbnail/11src/editorImg/20240222/71401705/1708568815531_E.jpg")
                .build();

        itemRepositoryJPA.save(item30);

        // 인테리어
        ItemEntity item31 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("듀오백")
                .itemName("듀오백 Q1W 메쉬 사무용 컴퓨터 책상 의자")
                .price(162000)
                .discount(4)
                .itemStars(4.7)
                .reviewNum(130)
                .category("인테리어")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/product/1677745288/B.png?518456023")
                .contentImg("https://www.duoback.co.kr/duo_online/new_quantum/q1w/q1w_01.jpg")
                .build();

        itemRepositoryJPA.save(item31);

        ItemEntity item32 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("잠스쿨")
                .itemName("잠스쿨 떡실신 토퍼매트리스 접이식 침대 바닥 3단 수면매트 매트릭스 7CM 12CM")
                .price(41540)
                .discount(27)
                .itemStars(4.7)
                .reviewNum(2751)
                .category("인테리어")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/dl/v2/8/1/6/3/6/9/OglQA/2261816369_196592001.jpg")
                .contentImg("https://pangs144.imghost.cafe24.com/web/upload/product/MS001/00_01.jpg")
                .build();

        itemRepositoryJPA.save(item32);

        ItemEntity item33 = ItemEntity.builder()
                .itemId(UUID.randomUUID())
                .brandName("KNOOK")
                .itemName("[KNOOK] KYO SERIES 01 - 1인용안락의자, 1인용쇼파, 1인용쇼파의자, 1인쇼파,독서의자,거실의자,서재의자,암체어, 라운지체어, 인테리어의자, 편한의자, 흔들의자")
                .price(172000)
                .discount(64)
                .itemStars(4.4)
                .reviewNum(5910)
                .category("인테리어")
                .itemImg("https://cdn.011st.com/11dims/resize/600x600/quality/75/11src/dl/v2/7/0/2/3/2/9/thbfM/8074702329_196628354.jpg")
                .contentImg("https://cdn.011st.com/11dims/thumbnail/11src/editorImg/20250310/75648094/1741617077753_E.jpg")
                .build();

        itemRepositoryJPA.save(item33);

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
