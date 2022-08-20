package com.emirhaneraslan.business.services;

import com.emirhaneraslan.business.dto.PostDto;
import com.emirhaneraslan.data.entity.PostEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IPostServices {
    //CRUD
    //save
    public PostEntity createPost(PostDto postDto);

    //list
    public List<PostEntity> getAllPost();

    //find
    public ResponseEntity<PostEntity> getPostById(Long id);

    public List<PostEntity> findByUser_UserId(Long userId);



}
