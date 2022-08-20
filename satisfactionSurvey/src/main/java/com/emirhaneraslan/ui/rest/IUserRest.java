package com.emirhaneraslan.ui.rest;

import com.emirhaneraslan.data.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IUserRest {

    UserEntity createUser(UserEntity userEntity);
    List<UserEntity> getAllUser();
    ResponseEntity<UserEntity> getUserById(Long id);
    ResponseEntity<UserEntity> updateUser(Long id,UserEntity userEntity);
    ResponseEntity<Map<String,Boolean>> deleteUser(Long id);
    List<UserEntity> findByIsActiveTrue();
    List<UserEntity> findByIsActiveFalse();
    UserEntity findByUserEmail(String email);

}
