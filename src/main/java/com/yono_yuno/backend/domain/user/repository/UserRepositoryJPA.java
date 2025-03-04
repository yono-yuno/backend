package com.yono_yuno.backend.domain.user.repository;

import com.yono_yuno.backend.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepositoryJPA extends JpaRepository<UserEntity, UUID> {
    UserEntity findByPhoneNum(String phoneNum);
    UserEntity findByPhoneNumAndPassWord(String phoneNum, String passWord);
}
