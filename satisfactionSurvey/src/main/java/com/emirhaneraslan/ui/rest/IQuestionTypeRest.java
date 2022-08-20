package com.emirhaneraslan.ui.rest;

import com.emirhaneraslan.data.entity.QuestionTypeEntity;
import com.emirhaneraslan.data.entity.SurveyEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IQuestionTypeRest {

    QuestionTypeEntity createQuestionType(QuestionTypeEntity questionTypeEntity);
    List<QuestionTypeEntity> getAllQuestionType();
    ResponseEntity<QuestionTypeEntity> getQuestionTypeById(Long id);
    ResponseEntity<QuestionTypeEntity> updateQuestionType(Long id,QuestionTypeEntity questionTypeEntity);
    ResponseEntity<Map<String,Boolean>> deleteQuestionType(Long id);

}
