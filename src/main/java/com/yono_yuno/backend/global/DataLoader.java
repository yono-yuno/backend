package com.yono_yuno.backend.global;

import com.yono_yuno.backend.domain.diary.entity.DiaryEntity;
import com.yono_yuno.backend.domain.diary.repository.DiaryRepositoryJPA;
import com.yono_yuno.backend.domain.item.ItemEntity;
import com.yono_yuno.backend.domain.item.ItemRepositoryJPA;
import com.yono_yuno.backend.domain.user.entity.UserEntity;
import com.yono_yuno.backend.domain.user.repository.UserRepositoryJPA;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserRepositoryJPA userRepositoryJPA;
    private final ItemRepositoryJPA itemRepositoryJPA;
    private final DiaryRepositoryJPA diaryRepositoryJPA;

    public DataLoader(UserRepositoryJPA userRepositoryJPA,ItemRepositoryJPA itemRepositoryJPA,DiaryRepositoryJPA diaryRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.itemRepositoryJPA = itemRepositoryJPA;
        this.diaryRepositoryJPA=diaryRepositoryJPA;
    }

    @Override
    public void run(String... args) throws Exception {
        // 기본 데이터 추가
        UserEntity user = UserEntity.builder()
                .userId(UUID.fromString("7bbb4645-7c9e-48c0-8928-d945c2584674"))
                .userName("홍길동")
                .phoneNum("01011112222")
                .passWord("123123")
                .build();

        userRepositoryJPA.save(user);

        ItemEntity item = ItemEntity.builder()
                .itemId(UUID.fromString("05054809-8229-4043-bff6-11892531dda4"))
                .price(50000)
                .category("식품")
                .build();
        itemRepositoryJPA.save(item);

        ItemEntity item1 = ItemEntity.builder()
                .itemId(UUID.fromString("baf0d7eb-930b-4116-8b4b-2eca57f7ea1d"))
                .price(20000)
                .category("식품")
                .build();
        itemRepositoryJPA.save(item1);

        ItemEntity item2 = ItemEntity.builder()
                .itemId(UUID.fromString("7c449d52-218c-42e2-8e4a-760c28316cdb"))
                .price(30000)
                .category("식품")
                .build();
        itemRepositoryJPA.save(item2);

        ItemEntity item3 = ItemEntity.builder()
                .itemId(UUID.fromString("16c959b7-a011-4e6a-b001-b2831679ad5d"))
                .price(30000)
                .category("패션잡화")
                .build();
        itemRepositoryJPA.save(item3);

        ItemEntity item4 = ItemEntity.builder()
                .itemId(UUID.fromString("ad784de7-d30f-4797-914c-d720e746fc70"))
                .price(100000)
                .category("패션잡화")
                .build();
        itemRepositoryJPA.save(item4);
/// ////////////////////////////////////////////////////////////////////////////////
        DiaryEntity diary = DiaryEntity.builder()
                .diaryId(UUID.randomUUID())
                .userId(UUID.fromString("7bbb4645-7c9e-48c0-8928-d945c2584674"))
                .consumerStars(3.2)
                .itemId(UUID.fromString("05054809-8229-4043-bff6-11892531dda4"))
                .firstReview("good")
                .detailDiary("bad")
                .build();
        diaryRepositoryJPA.save(diary);

        DiaryEntity diary1 = DiaryEntity.builder()
                .diaryId(UUID.randomUUID())
                .userId(UUID.fromString("7bbb4645-7c9e-48c0-8928-d945c2584674"))
                .consumerStars(3.2)
                .itemId(UUID.fromString("baf0d7eb-930b-4116-8b4b-2eca57f7ea1d"))
                .firstReview("good")
                .detailDiary("bad")
                .build();
        diaryRepositoryJPA.save(diary1);

        DiaryEntity diary2 = DiaryEntity.builder()
                .diaryId(UUID.randomUUID())
                .userId(UUID.fromString("7bbb4645-7c9e-48c0-8928-d945c2584674"))
                .consumerStars(3.2)
                .itemId(UUID.fromString("7c449d52-218c-42e2-8e4a-760c28316cdb"))
                .firstReview("good")
                .detailDiary("bad")
                .build();
        diaryRepositoryJPA.save(diary2);

        DiaryEntity diary3 = DiaryEntity.builder()
                .diaryId(UUID.randomUUID())
                .userId(UUID.fromString("7bbb4645-7c9e-48c0-8928-d945c2584674"))
                .consumerStars(3.2)
                .itemId(UUID.fromString("05054809-8229-4043-bff6-11892531dda4"))
                .firstReview("good")
                .detailDiary("bad")
                .build();
        diaryRepositoryJPA.save(diary3);

        DiaryEntity diary4 = DiaryEntity.builder()
                .diaryId(UUID.randomUUID())
                .userId(UUID.fromString("7bbb4645-7c9e-48c0-8928-d945c2584674"))
                .consumerStars(3.2)
                .itemId(UUID.fromString("16c959b7-a011-4e6a-b001-b2831679ad5d"))
                .firstReview("good")
                .detailDiary("bad")
                .build();
        diaryRepositoryJPA.save(diary4);

        DiaryEntity diary5 = DiaryEntity.builder()
                .diaryId(UUID.randomUUID())
                .userId(UUID.fromString("7bbb4645-7c9e-48c0-8928-d945c2584674"))
                .consumerStars(3.2)
                .itemId(UUID.fromString("16c959b7-a011-4e6a-b001-b2831679ad5d"))
                .firstReview("good")
                .detailDiary("bad")
                .build();
        diaryRepositoryJPA.save(diary5);
    }
}
