package com.emirhaneraslan.business.services;

import com.emirhaneraslan.data.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IUserServices {


    //CRUD
    //save
    public UserEntity createUser(UserEntity userEntity);

    //list
    public List<UserEntity> getAllUser();

    //find
    public ResponseEntity<UserEntity> getUserById(Long id);

    //update
    public ResponseEntity<UserEntity> updateUser(Long id,UserEntity userEntity);

    //delete
    public ResponseEntity<Map<String,Boolean>> deleteUser(Long id);

    List<UserEntity> findByIsActiveTrue();
    List<UserEntity> findByIsActiveFalse();
    UserEntity findByUserEmail(String email);

}
