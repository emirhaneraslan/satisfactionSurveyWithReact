package com.emirhaneraslan.business.services.impl;

import com.emirhaneraslan.business.services.IUserServices;
import com.emirhaneraslan.data.entity.UserEntity;
import com.emirhaneraslan.data.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;


@Service
@Log4j2
public class UserServiceImpl implements IUserServices {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserEntity createUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        log.info("Ekleme başarılı");
        return userEntity;
    }

    @Override
    public List<UserEntity> getAllUser() {
        List<UserEntity> list = new ArrayList<>();
        Iterable<UserEntity> myList = userRepository.findAll();
        for (UserEntity user: myList) {
            list.add(user);
        }
        return list;
    }

    @Override
    public ResponseEntity<UserEntity> getUserById(Long id) {
        UserEntity userEntity=userRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(userEntity);
    }

    @Override
    public ResponseEntity<UserEntity> updateUser(Long id, UserEntity userEntity) {
        UserEntity user=userRepository.findById(id).orElseThrow();

        user.setUserName(userEntity.getUserName());
        user.setUserSurname(userEntity.getUserSurname());
        user.setUserEmail(userEntity.getUserEmail());
        user.setUserAdress(userEntity.getUserAdress());
        user.setCreatedDate(new Date());
        user.setActive(userEntity.isActive());

        UserEntity userEntity1=userRepository.save(user);

        return ResponseEntity.ok(userEntity1);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow();
        userRepository.delete(userEntity);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<UserEntity> findByIsActiveTrue() {
        Iterable<UserEntity> myList=this.userRepository.findByIsActiveTrue();
        List<UserEntity> list = new ArrayList<>();

        for (UserEntity user: myList) {
            list.add(user);
        }
        return list;
    }

    @Override
    public List<UserEntity> findByIsActiveFalse() {
        Iterable<UserEntity> myList=this.userRepository.findByIsActiveFalse();
        List<UserEntity> list = new ArrayList<>();

        for (UserEntity user: myList) {
            list.add(user);
        }
        return list;
    }

    @Override
    public UserEntity findByUserEmail(String email) {
        UserEntity entity = this.userRepository.findByUserEmail(email);
        return entity;
    }
}
