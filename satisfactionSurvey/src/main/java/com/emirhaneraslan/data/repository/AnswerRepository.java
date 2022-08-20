package com.emirhaneraslan.data.repository;

import com.emirhaneraslan.data.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity,Long> {

    //List<QuestionEntity> findBySurvey_SurveyId(Long surveyId);

    List<AnswerEntity> findByQuestion_Survey_SurveyId(Long surveyId);
}
