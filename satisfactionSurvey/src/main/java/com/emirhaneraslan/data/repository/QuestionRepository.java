package com.emirhaneraslan.data.repository;

import com.emirhaneraslan.data.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity,Long> {

        List<QuestionEntity> findBySurvey_SurveyId(Long surveyId);



}
