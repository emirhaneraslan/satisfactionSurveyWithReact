package com.emirhaneraslan.ui.rest;

import com.emirhaneraslan.business.dto.QuestionDto;
import com.emirhaneraslan.data.entity.QuestionEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IQuestionRest {

     QuestionEntity createQuestion(QuestionDto questionDto);
     List<QuestionEntity> getAllQuestion();
     ResponseEntity<QuestionEntity> getQuestionById(Long id);
     List<QuestionEntity> findBySurvey_SurveyId(Long surveyId);

     }
