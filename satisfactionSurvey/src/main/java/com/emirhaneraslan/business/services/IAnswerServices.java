package com.emirhaneraslan.business.services;

import com.emirhaneraslan.business.dto.AnswerDto;
import com.emirhaneraslan.business.dto.QuestionDto;
import com.emirhaneraslan.data.entity.AnswerEntity;
import com.emirhaneraslan.data.entity.QuestionEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAnswerServices {

    public AnswerEntity createAnswer(AnswerDto answerDto);

    //list
    public List<AnswerEntity> getAllAnswer();

    //find
    public ResponseEntity<AnswerEntity> getAnswerById(Long id);

    List<AnswerEntity> findByQuestion_Survey_SurveyId(Long surveyId);
}
