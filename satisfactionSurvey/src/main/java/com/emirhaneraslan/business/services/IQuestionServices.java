package com.emirhaneraslan.business.services;

import com.emirhaneraslan.business.dto.QuestionDto;
import com.emirhaneraslan.data.entity.QuestionEntity;
import com.emirhaneraslan.data.entity.SurveyEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IQuestionServices{

    //CRUD
    //save
    public QuestionEntity createQuestion(QuestionDto questionDto);

    //list
    public List<QuestionEntity> getAllQuestion();

    //find
    public ResponseEntity<QuestionEntity> getQuestionById(Long id);

    List<QuestionEntity> findBySurvey_SurveyId(Long surveyId);




}
