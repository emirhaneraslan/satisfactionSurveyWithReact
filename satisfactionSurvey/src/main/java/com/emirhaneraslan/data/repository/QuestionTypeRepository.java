package com.emirhaneraslan.data.repository;

import com.emirhaneraslan.data.entity.QuestionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionTypeEntity,Long> {


}
