package com.emirhaneraslan.ui.rest.impl;

import com.emirhaneraslan.business.dto.PostDto;
import com.emirhaneraslan.business.services.IPostServices;
import com.emirhaneraslan.data.entity.PostEntity;
import com.emirhaneraslan.ui.rest.IPostRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post/")
public class PostRestImpl implements IPostRest {

    @Autowired
    IPostServices iPostServices;

    @Override
    @PostMapping("save")
    public PostEntity createPost(@RequestBody PostDto postDto) {
        return this.iPostServices.createPost(postDto);
    }

    @Override
    @GetMapping("findAll")
    public List<PostEntity> getAllPost() {
        return this.iPostServices.getAllPost();
    }

    @Override
    @GetMapping("getbyid/{id}")
    public ResponseEntity<PostEntity> getPostById(@PathVariable(name = "id") Long id) {
        return this.iPostServices.getPostById(id);
    }

    @Override
    @GetMapping("getbyuserid/{id}")
    public List<PostEntity> findByUser_UserId(@PathVariable(name = "id") Long userId) {
        return this.iPostServices.findByUser_UserId(userId);
    }
}
