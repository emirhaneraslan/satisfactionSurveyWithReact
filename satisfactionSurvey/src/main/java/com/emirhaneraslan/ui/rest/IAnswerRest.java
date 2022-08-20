package com.emirhaneraslan.ui.rest;

import com.emirhaneraslan.business.dto.AnswerDto;
import com.emirhaneraslan.data.entity.AnswerEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAnswerRest {

    AnswerEntity createAnswer(AnswerDto answerDto);

    //list
    List<AnswerEntity> getAllAnswer();

    //find
    ResponseEntity<AnswerEntity> getAnswerById(Long id);

    List<AnswerEntity> findByQuestion_Survey_SurveyId(Long surveyId);
}
