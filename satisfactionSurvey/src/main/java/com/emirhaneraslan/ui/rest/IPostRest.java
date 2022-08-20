package com.emirhaneraslan.ui.rest;

import com.emirhaneraslan.business.dto.PostDto;
import com.emirhaneraslan.data.entity.PostEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPostRest {

    //save
    PostEntity createPost(PostDto postDto);

    //list
    List<PostEntity> getAllPost();

    //find
    ResponseEntity<PostEntity> getPostById(Long id);

    List<PostEntity> findByUser_UserId(Long userId);
}
