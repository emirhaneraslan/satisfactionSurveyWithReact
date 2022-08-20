package com.emirhaneraslan.data.repository;

import com.emirhaneraslan.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    List<UserEntity> findByIsActiveTrue();
    List<UserEntity> findByIsActiveFalse();
    UserEntity findByUserEmail(String email);

}
