package com.emirhaneraslan.ui.rest.impl;

import com.emirhaneraslan.business.services.IUserServices;
import com.emirhaneraslan.data.entity.UserEntity;
import com.emirhaneraslan.ui.rest.IUserRest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin
public class UserRestImpl implements IUserRest {

    @Autowired
    IUserServices iUserServices;

    @Override
    @PostMapping("save")
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        iUserServices.createUser(userEntity);
        return userEntity;
    }

    @Override
    @GetMapping("findAll")
    public List<UserEntity> getAllUser() {
        List<UserEntity> myList=iUserServices.getAllUser();
        return myList;
    }

    @Override
    @GetMapping("getbyid/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable(name = "id") Long id) {
        ResponseEntity<UserEntity> findUser =iUserServices.getUserById(id);
        return findUser;
    }

    @Override
    @PutMapping("update/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable(name = "id") Long id,@RequestBody UserEntity userEntity) {
        ResponseEntity<UserEntity> updateUser=iUserServices.updateUser(id,userEntity);
        return updateUser.ok(userEntity);
    }

    @Override
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable(name = "id") Long id) {
        iUserServices.deleteUser(id);
        Map<String,Boolean> deleteUser=new HashMap<>();
        deleteUser.put("Silindi",Boolean.TRUE);
        return ResponseEntity.ok(deleteUser);
    }

    @Override
    @GetMapping("activetrue")
    public List<UserEntity> findByIsActiveTrue() {
        return this.iUserServices.findByIsActiveTrue();
    }

    @Override
    @GetMapping("activefalse")
    public List<UserEntity> findByIsActiveFalse() {
        return this.iUserServices.findByIsActiveFalse();
    }

    @Override
    @GetMapping("findbyemail/{email}")
    public UserEntity findByUserEmail(@PathVariable(name = "email") String email) {
        return this.iUserServices.findByUserEmail(email);
    }


}
