package com.emirhaneraslan.data.repository;

import com.emirhaneraslan.data.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {

    List<PostEntity> findByUser_UserId(Long userId);

}
