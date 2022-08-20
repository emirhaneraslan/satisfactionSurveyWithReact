package com.emirhaneraslan.business.services.impl;

import com.emirhaneraslan.business.dto.PostDto;
import com.emirhaneraslan.business.services.IPostServices;
import com.emirhaneraslan.data.entity.AnswerEntity;
import com.emirhaneraslan.data.entity.PostEntity;
import com.emirhaneraslan.data.entity.QuestionEntity;
import com.emirhaneraslan.data.entity.UserEntity;
import com.emirhaneraslan.data.repository.PostRepository;
import com.emirhaneraslan.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements IPostServices {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public PostEntity createPost(PostDto postDto) {
        UserEntity userEntity= this.userRepository.findById(postDto.getUserId()).orElseThrow();

        PostEntity postEntity= new PostEntity();

        postEntity.setUser(userEntity);
        postEntity.setPostBody(postDto.getPostBody());
        postEntity.setPostTitle(postDto.getPostTitle());
        postEntity.setImageUrl(postDto.getImageUrl());

        postRepository.save(postEntity);

        return postEntity;
    }

    @Override
    public List<PostEntity> getAllPost() {
        List<PostEntity> list = new ArrayList<>();
        Iterable<PostEntity> myList= postRepository.findAll();

        for (PostEntity posts: myList) {
            list.add(posts);
        }
        return list;
    }

    @Override
    public ResponseEntity<PostEntity> getPostById(Long id) {
        PostEntity postEntity=this.postRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(postEntity);
    }

    @Override
    public List<PostEntity> findByUser_UserId(Long userId) {
        Iterable<PostEntity> myList= this.postRepository.findByUser_UserId(userId);
        List<PostEntity> list= new ArrayList<>();

        for (PostEntity post : myList) {
            list.add(post);
        }
        return list;
    }

}
